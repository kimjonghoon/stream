# Java 8 stream example

### How to run (Windows)
    md out
	cd src\net\java_school\examples
	javac -d ..\..\..\..\out *.java
	cd ..\..\..\..\
	java -cp out net.java_school.examples.MovieTest
	
	The Shawshank Redemption
	The Dark Knight
	The Silence Of The Lambs
	
	Tschick,2016,7.0
	Small Town Crime,2017,6.6
	The Commuter,2018,6.3
	
	Average Rating: 7.456896551724138
	
### How to run (Linux)
    javac -d out -sourcepath src $(find src -name "*.java")
    java -cp out net.java_school.examples.MovieTest
    
    The Shawshank Redemption
    The Dark Knight
    The Silence Of The Lambs

    Tschick,2016,7.0
    Small Town Crime,2017,6.6
    The Commuter,2018,6.3

    Average Rating: 7.456896551724138    
