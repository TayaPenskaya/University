package ru.ifmo.rain.penskaya.walk;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.Path;


public class Walk {
    private static final int FNV1_32_INIT = 0x811c9dc5;
    private static final int FNV1_PRIME_32 = 0x01000193;

    public static int getHash(String fileName) throws IOException {
        int hash = FNV1_32_INIT;
        byte[] data = new byte[1024];
        int count;
        try (InputStream stream = Files.newInputStream(Paths.get(fileName))) {
            while ((count = stream.read(data)) >= 0) {
                for (int i = 0; i < count; i++) {
                    hash *= FNV1_PRIME_32;
                    hash ^= data[i] & 0xff;
                }
            }
            return hash;
        } catch (IOException | InvalidPathException e ) {
            System.err.println("Can't read file!");
            return 0x00000000;
        }
    }


    public static void main(String[] args) {

        if (args == null) {
            System.err.println("Invalid args");
            return;
        }

        if (args.length < 2) {
            System.err.println("Not enough arguments!");
            return;
        }
        if (args[0] == null) {
            System.err.println("Missing file");
            return;
        }
        if (args[1] == null) {
            System.err.println("Missing file");
            return;
        }

        Path[] paths = new Path[2];
        try {
            for (int i = 0; i < paths.length; i++) {
                paths[i] = Paths.get(args[i]);
            }
        } catch (InvalidPathException e) {
            System.err.println("Can't get paths from args!");
            return;
        }

        if (paths[1].getParent() != null) {
            try {
                Files.createDirectories(paths[1].getParent());
            } catch (IOException e) {
                System.err.println("Can't create parent-directories for output file!");
            }
        }

        try (BufferedReader br = Files.newBufferedReader(Paths.get(args[0]), StandardCharsets.UTF_8)) {
            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(args[1]), StandardCharsets.UTF_8)) {
                String line;
                try {
                    while ((line = br.readLine()) != null) {
                        int currentHash;
                        try {
                            currentHash = getHash(line);
                        } catch (IOException e) {
                            currentHash = 0;
                        }
                        try {
                            bw.write(String.format("%08x %s%n", currentHash, line));
                        } catch (IOException e) {
                            System.err.println("Can't write to " + args[1]);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Can't read to " + args[0]);
                }
            } catch (NoSuchFileException e) {
                System.err.println("No such file!");
            } catch (IOException e) {
                System.err.println("Can't read or write to " + args[1]);
            } catch (SecurityException e) {
                System.err.println("Security exception");
            }
        } catch (NoSuchFileException e) {
            System.err.println("No such file!");
        } catch (IOException e) {
            System.err.println("Can't read to" + args[0]);
        } catch (SecurityException e) {
            System.err.println("Security exception");
        }
    }
}

