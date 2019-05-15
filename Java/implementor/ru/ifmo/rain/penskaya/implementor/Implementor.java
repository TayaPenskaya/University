package ru.ifmo.rain.penskaya.implementor;

import info.kgeorgiy.java.advanced.implementor.Impler;
import info.kgeorgiy.java.advanced.implementor.ImplerException;
import info.kgeorgiy.java.advanced.implementor.JarImpler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Implementor implements Impler, JarImpler {
    @Override
    public void implement(Class<?> aClass, Path path) throws ImplerException {
        if (aClass.isPrimitive() || aClass.isArray() || aClass == Enum.class || Modifier.isFinal(aClass.getModifiers())) {
            throw new ImplerException("It isn't a class or interface!");
        }
        path = getFilePath(path, aClass);
        createDirectories(path);
        try (var writer = Files.newBufferedWriter(path)) {
            writePackage(aClass, writer);
            writeClassFullName(aClass, writer);
            if (!aClass.isInterface()) {
                writeConstructors(aClass, writer);
            }
            writeMethods(aClass, writer);
            writer.write(RIGHT_BRACE + COMMA);
        } catch (IOException e) {
            throw new ImplerException("Can't write implementation for this class!");
        }

    }

    public static void main(String[] args) {
        if (args == null || args.length != 2 || args[0] == null || args[1] == null) {
            System.err.println("Not good arguments!");
            return;
        }

        var className = args[0];
        var path = args[1];
        var implementor = new Implementor();
        try {
            var cl = Class.forName(className);
            var p = Paths.get(path);
            implementor.implement(cl, p);
        } catch (ClassNotFoundException ignored) {
            System.err.println("Class not found!");
        } catch (ImplerException ignored) {
            System.err.println("Can't generate implementation of a class!");
        }
    }

    private final static String SUFFIX = "Impl";

    private String getClassName(Class<?> cl) {
        return cl.getSimpleName() + SUFFIX;
    }

    private final static String COMMA = ";";

    private String getPackageName(Class<?> cl) {
        if (!cl.getPackage().getName().equals("")) {
            return "package " + cl.getPackageName() + COMMA + System.lineSeparator() + System.lineSeparator();
        } else {
            return "";
        }
    }

    private void writePackage(Class<?> cl, BufferedWriter writer) throws IOException {
        writer.write(getPackageName(cl));
    }

    private final static String LEFT_BRACE = "{";
    private final static String RIGHT_BRACE = "}";

    private void writeClassFullName(Class<?> cl, BufferedWriter writer) throws IOException {
        writer.write("public class " + getClassName(cl) + (cl.isInterface() ? " implements " : " extends ") + cl.getSimpleName()
                + " " + LEFT_BRACE + System.lineSeparator() + System.lineSeparator());
    }

    private final static String LEFT_PARENTHESIS = "(";
    private final static String RIGHT_PARENTHESIS = ")";

    private void writeConstructors(Class<?> cl, BufferedWriter writer) throws IOException, ImplerException {
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        boolean has = false;
        for (Constructor c : constructors) {
            int mod = c.getModifiers();
            if (!Modifier.isPrivate(mod)) {
                has = true;
                if (Modifier.isPublic(mod)) {
                    writer.write("public ");
                } else if (Modifier.isProtected(mod)) {
                    writer.write("protected ");
                }
                writer.write(cl.getSimpleName() + SUFFIX + LEFT_PARENTHESIS);
                Parameter[] parameters = c.getParameters();
                for (Parameter p : parameters) {
                    if (p == parameters[parameters.length - 1]) {
                        writer.write(p.getType().getCanonicalName() + " " + p.getName());
                    } else {
                        writer.write(p.getType().getCanonicalName() + " " + p.getName() + ", ");
                    }
                }
                writer.write(RIGHT_PARENTHESIS);
                Class[] exceptions = c.getExceptionTypes();
                if (exceptions.length != 0) {
                    writer.write(" throws ");
                    for (Class e : exceptions) {
                        if (e == exceptions[exceptions.length - 1]) {
                            writer.write(e.getName());
                        } else {
                            writer.write(e.getName() + ", ");
                        }
                    }
                }
                writer.write("  " + LEFT_BRACE + System.lineSeparator());
                writer.write("super(");
                for (Parameter p : parameters) {
                    if (p == parameters[parameters.length - 1]) {
                        writer.write(p.getName());
                    } else {
                        writer.write(p.getName() + ", ");
                    }
                }
                writer.write(RIGHT_PARENTHESIS + COMMA + System.lineSeparator() + RIGHT_BRACE + System.lineSeparator() + System.lineSeparator());
            }
        }
        if (!has) {
            throw new ImplerException("Have no public constructors");
        }
    }

    private void writeMethods(Class<?> cl, BufferedWriter writer) throws IOException {
        Method[] methods = cl.getMethods();
        Set<Method> abstractMethods = new HashSet<>(Arrays.asList(methods));
        while (cl != null) {
            if (!Modifier.isAbstract(cl.getModifiers())) {
                break;
            }
            for (Method method : cl.getDeclaredMethods()) {
                int m = method.getModifiers();
                if (!Modifier.isPrivate(m) && !Modifier.isPublic(m)) {
                    abstractMethods.add(method);
                }
            }
            cl = cl.getSuperclass();
        }
        abstractMethods.removeIf(method -> !Modifier.isAbstract(method.getModifiers()));
        for (Method m : abstractMethods) {
            int mod = m.getModifiers();
            if (!Modifier.isPrivate(mod) && !Modifier.isFinal(mod)) {
                writer.write("public ");
                writer.write(m.getReturnType().getCanonicalName() + " " + m.getName() + LEFT_PARENTHESIS);
                Parameter[] parameters = m.getParameters();
                for (Parameter p : parameters) {
                    if (p == parameters[parameters.length - 1]) {
                        writer.write(p.getType().getCanonicalName() + " " + p.getName());
                    } else {
                        writer.write(p.getType().getCanonicalName() + " " + p.getName() + ", ");
                    }
                }
                writer.write(RIGHT_PARENTHESIS);
                Class[] exceptions = m.getExceptionTypes();
                if (exceptions.length != 0) {
                    writer.write(" throws ");
                    for (Class e : exceptions) {
                        if (e == exceptions[exceptions.length - 1]) {
                            writer.write(e.getName());
                        } else {
                            writer.write(e.getName() + ", ");
                        }
                    }
                }
                writer.write(" " + LEFT_BRACE + System.lineSeparator());
                writer.write("\t return ");
                if (!m.getReturnType().isPrimitive()) {
                    writer.write("null");
                } else {
                    switch (m.getReturnType().toString()) {
                        case "boolean":
                            writer.write("false");
                            break;
                        case "void":
                            writer.write("");
                            break;
                        default:
                            writer.write("0");
                    }
                }
                writer.write(COMMA + System.lineSeparator());
                writer.write(RIGHT_BRACE + System.lineSeparator() + System.lineSeparator());
            }
        }
    }

    private Path getFilePath(Path path, Class<?> cl) {
        return path.resolve(cl.getPackage().getName().replace('.', File.separatorChar)).resolve(String.format("%s.%s", cl.getSimpleName().concat(SUFFIX), "java"));
    }

    private void createDirectories(Path path) {
        if (path.getParent() != null) {
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e) {
                System.err.println("Can't create directory!");
            }
        }

    }

    @Override
    public void implementJar(Class<?> aClass, Path path) throws ImplerException {

    }
}


//java -cp . -p . -m info.kgeorgiy.java.advanced.implementor class ru.ifmo.rain.penskaya.implementor.Implementor
