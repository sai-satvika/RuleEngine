# RuleEngine
A simple rule evaluation engine in Java
# RuleEngine

## Overview
The `RuleEngine` is a simple rule evaluation engine implemented in Java. It allows users to create, modify, and evaluate rules based on various operators and operands. The engine supports user-defined functions and provides persistence through file operations.

## Features
- **Rule Creation**: Create new rules using a simple string format.
- **Rule Modification**: Modify existing rules by index.
- **Rule Evaluation**: Evaluate rules against a set of data.
- **Error Handling**: Provides meaningful error messages for invalid operations.
- **Support for Operators**: Supports operators like `>`, `<`, `==`, `>=`, `<=`, and `!=`.
- **User  -Defined Functions**: Allows users to register custom functions for evaluation.
- **Persistence**: Save and load rules from a file.
- **Extensibility**: Easily extendable for future enhancements.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/sai-satvika/RuleEngine.git
2. Navigate to the project directory:
   ```bash
   cd RuleEngine
3.Compile the Java file:
```bash
   javac src/RuleEngine.java


## Usage

### Creating a Rule
To create a new rule, use the `createRule` method:
```java
RuleEngine engine = new RuleEngine();
engine.createRule("x > 10");

