
F = ImplementationRMI
# start rmiregistry 1234 # where 1234 is the port name

comp: $(F)_Stub.java $(F).class maniFest.txt
	jar cFm name.jar maniFest.txt $(F).class $(F)_Stub.class InterFaceRMI.class

$(F)_Stub.java: $(F).class
	rmic ImplementationRMI 

$(F).class: $(F).java
	javac *.java

clear:
	del *.class 