# before you commit
clean:
	rm -rf ./*.class

# to run the project
run:
	clear
	javac *.java
	java -cp . Driver