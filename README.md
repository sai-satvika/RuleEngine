Rule Engine with Abstract Syntax Tree (AST)
Objective
This project implements a 3-tier rule engine application that determines user eligibility based on various attributes like age, department, income, spend, etc. The system uses an Abstract Syntax Tree (AST) to represent conditional rules, allowing dynamic creation, modification, and combination of rules.

Features
Dynamic Rule Creation: Rules can be created dynamically based on user attributes.
AST Representation: Conditional rules are represented using an Abstract Syntax Tree (AST) for efficient parsing and evaluation.
Rule Combination: Multiple rules can be combined to form more complex eligibility criteria, with optimized performance through reduced redundant checks.
Simple API Design: Create and combine rules programmatically using the exposed API.
Application Design
1. Data Structure
The data structure is based on an AST, with nodes representing conditions and logical operators. Each node has the following attributes:

Type: Defines whether the node is an "operator" (e.g., AND/OR) or an "operand" (e.g., conditions like age, salary).
Left and Right: References to child nodes for representing binary operations.
Value: The condition or operand value (e.g., age > 30, department = 'Sales').
2. API Design
The project provides two main API functions:

create_rule(rule_string): This function parses a rule string (e.g., "age > 30 AND department = 'Sales'") and constructs the corresponding AST, returning the root node of the tree.
combine_rules(rules): This function takes a list of rule strings, optimizes their combination, and returns a combined AST representing the merged rules. The aim is to reduce redundant checks and improve efficiency.
