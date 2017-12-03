
FILE = PetsGUI

# Dependencias
compile: classes $(FILE).java mysqlcon.jar
	javac -cp .:mysqlcon.jar *.java -d classes/ # Ponemos los *.class en el directorio classes
run:
	java -cp ./classes:mysqlcon.jar PetsGUI # Corremos el PetsGUI.class ubicado en classes
classes: 
	mkdir classes 

