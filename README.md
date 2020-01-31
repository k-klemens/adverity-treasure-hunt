# adverity-treasure-hunt
Implementing the Treasure Hunt Challenge using Java.
For tests JUnit 5.6.0 is being used.
As a project setup/dependecy management maven is used.

## Running the Project using maven
Having maven installed the project can be run by using one of the following commands:
- `mvn clean package exec:java -Dexec.mainClass="com.kaesznar.klemens.treasure.hunt.functional.FunctionalMain"` to run the recursive approach using primitve data-types.
- `mvn clean package exec:java -Dexec.mainClass="com.kaesznar.klemens.treasure.hunt.oo.OOMain"` to run the non-recursive approach using objects.

By default the Main-Classes are set up to use a faked Stdin, to read data from the "real" Stdin, just comment out the 'fakeinputStream()'-method which is being called in `OOMain` and also `FunctionalMain`.
