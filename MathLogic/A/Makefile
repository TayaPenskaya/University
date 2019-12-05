MAINCLASS = Main

all: 
	javac -cp src src/Main.java

run:
	java -cp src ${MAINCLASS}
	
pack:
	zip A.zip -r Makefile src

clean:
	rm -rf out

out:
	mkdir -p out

