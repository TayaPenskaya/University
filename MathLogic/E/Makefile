MAINCLASS = Main

all: 
	javac -cp src src/Main.java

run:
	java -cp src ${MAINCLASS}
	
pack:
	zip E.zip -r Makefile src/*/*.java src/*.java

clean:
	rm -rf out

out:
	mkdir -p out