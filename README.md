# Dataflow language for implementation of artificial neural network models (Flow)

A compiler for the Flow-language which is used to implement data-flow models, and artificial neural network models in particular. (Project language level: Java 11)

## Dependencies
Add the four .jar dependencies in the libraries-folder as libraries in the project:
- java-cup-11b.jar (CUP - https://versioncontrolseidl.in.tum.de/parsergenerators/cup)
- java-cup-11b-runtime.jar (CUP Runtime - https://versioncontrolseidl.in.tum.de/parsergenerators/cup)
- jflex-full-1.7.0.jar (JFlex - https://github.com/jflex-de/jflex)
- LinearAlgebra.jar (Raonox - https://github.com/niki9796dk/Raonox)

## Building the project
The compiler is dependent on JFlex and Cup for generating the scanner and parser based on the specification-files in JFlex/specification.jflex and Cup/specification.cup.
To allow running these, an ant-script needs to be added and run prior to compilation. The ant-script is called build.xml. (Intellij allows right-clicking the compile-target -> execute on -> before compilation)

## Using the compiler
- To compile a single program written in the Flow-language, insert the code in the data/input.txt file and run the src/AutoGen/MainParse.java main method.
- The generated java-code will appear in a package with the name of the text-file the program was written in, inside the src/AutoGen/CodeGen package. The generated classes are the blocks declared in the program-file and can be used as objects in java. 
- An instance of a block-class can be trained with the "train"-method, and later evaluated with the "evaluateInput"-method. 
- An example of using a block-class can be found in src/CodeGeneration/DataFlow/Executions/MainBlock.java.

## Documentation
A large part of the code-base is documented using the Javadoc-standard which should help increase readability and maintainability. The generated index-page can be found in the Documentation/JavaDoc.zip folder.\
The design, implementation, and general creation of the compiler is described in the project report in Documentation/LanguageReportDocumentation.pdf

# Group Members and Report:
Christian Graae Zandersen, Daniel Thomsen, Jesper Adriaan van Diepen, Mike Lund Andersen, Niki Ewald Zakariassen, Simon Steiner

[Report](Report.pdf)
