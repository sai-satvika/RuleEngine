## Running in Eclipse

1. Open Eclipse IDE.
2. Go to File > Import > General > Existing Projects into Workspace.
3. Select the root directory of the cloned project.
4. Ensure the project is checked in the "Projects" list.
5. Click "Finish" to import the project.
6. Right-click on the `Main.java` file in the Package Explorer.
7. Select "Run As" > "Java Application" to run the program.
## Build Instructions

### Using Command Line:

1. Clone the repository
2. Compile the Java files
3. Run the application
       
### Using Eclipse IDE:

1. Clone the repository as mentioned above.
2. Open Eclipse and import the project (File > Import > General > Existing Projects into Workspace).
3. Eclipse will automatically build the project.
4. Run the `Main.java` file as a Java Application.

## Troubleshooting

- If you encounter a "Source folder is not on project's build path" error in Eclipse, right-click on the project in Package Explorer, select "Properties" > "Java Build Path", and ensure the "src" folder is added as a source folder.
- If you see "The declared package does not match the expected package" warning, ensure your project structure matches the package declarations in the Java files.

## Testing

The current implementation doesn't include formal unit tests. To test the functionality:

1. Run the `Main.java` file in Eclipse (or via command line as described in the Build Instructions).
2. Check the console output to verify that the rules are being evaluated correctly.
3. Modify the rules or input data in `Main.java` to test different scenarios.

## Note on Development Environment

This project has been successfully tested in Eclipse IDE. Users of other IDEs like IntelliJ IDEA or NetBeans should be able to import and run the project with similar steps, adjusting for their specific IDE's import and run procedures.
