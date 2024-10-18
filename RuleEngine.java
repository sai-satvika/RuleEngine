package src;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class RuleEngine {
    private List<String> rules = new ArrayList<>();
    private Map<String, Function<Map<String, Object>, Boolean>> userDefinedFunctions = new HashMap<>();

    // Method to create a new rule
    public void createRule(String ruleString) {
        Node ast = parseRuleString(ruleString);
        rules.add(ruleString); // Store the rule string or AST as needed
    }

    // Method to modify an existing rule
    public void modifyRule(int index, String newRuleString) {
        if (index >= 0 && index < rules.size()) {
            rules.set(index, newRuleString);
        } else {
            throw new IndexOutOfBoundsException("Invalid rule index.");
        }
    }

    // Method to register user-defined functions
    public void registerFunction(String name, Function<Map<String, Object>, Boolean> function) {
        userDefinedFunctions.put(name, function);
    }

    // Method to evaluate a rule
    public boolean evaluateRule(String ruleString, Map<String, Object> data) {
        Node ast = parseRuleString(ruleString);
        return evaluateNode(ast, data);
    }

    // Method to parse the rule string into an abstract syntax tree (AST)
    private Node parseRuleString(String ruleString) {
        String[] tokens = ruleString.split(" ");
        if (tokens.length == 3) {
            Node left = new Node(Node.NodeType.OPERAND, tokens[0]);
            Node right = new Node(Node.NodeType.OPERAND, tokens[2]);
            return new Node(Node.NodeType.OPERATOR, tokens[1], left, right);
        }
        throw new IllegalArgumentException("Invalid rule format.");
    }

    // Method to evaluate nodes in the AST
    private boolean evaluateNode(Node node, Map<String, Object> data) {
        if (node.type == Node.NodeType.OPERAND) {
            return evaluateOperand(node, data);
        } else if (node.type == Node.NodeType.OPERATOR) {
            return evaluateOperator(node, data);
        }
        return false;
    }

    // Method to evaluate operands
    private boolean evaluateOperand(Node node, Map<String, Object> data) {
        // Check if the operand exists in the data map
        if (data.containsKey(node.value)) {
            return (Boolean) data.get(node.value);
        } else if (userDefinedFunctions.containsKey(node.value)) {
            return userDefinedFunctions.get(node.value).apply(data);
        }
        throw new IllegalArgumentException("Undefined operand: " + node.value);
    }

    // Method to evaluate operators
    private boolean evaluateOperator(Node node, Map<String, Object> data) {
        Object leftValue = data.get(node.left.value);
        Object rightValue;

        // Check if the right operand is a number or a variable
        if (node.right.value.matches("\\d+")) { // Check if it's a number
            rightValue = Integer.parseInt(node.right.value);
        } else {
            rightValue = data.get(node.right.value);
        }

        if (leftValue == null) {
            throw new IllegalArgumentException("Undefined variable in expression: " + node.left.value);
        }

        switch (node.value) {
            case ">":
                return ((Comparable) leftValue).compareTo(rightValue) > 0;
            case "<":
                return ((Comparable) leftValue).compareTo(rightValue) < 0;
            case "==":
                return leftValue.equals(rightValue);
            case ">=":
                return ((Comparable) leftValue).compareTo(rightValue) >= 0;
            case "<=":
                return ((Comparable) leftValue).compareTo(rightValue) <= 0;
            case "!=":
                return !leftValue.equals(rightValue);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + node.value);
        }
    }

    // Method to save rules to a file
    public void saveRulesToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String rule : rules) {
                writer.write(rule);
                writer.newLine();
            }
        }
    }

    // Method to load rules from a file
    public void loadRulesFromFile(String filename) throws IOException {
        rules.clear(); // Clear existing rules
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                createRule(line);
            }
        }
    }

    // Node class representing the structure of the AST
    private static class Node {
        enum NodeType { OPERAND, OPERATOR }
        NodeType type;
        String value;
        Node left;
        Node right;

        Node(NodeType type, String value) {
            this.type = type;
            this.value = value;
        }

        Node(NodeType type, String value, Node left, Node right) {
            this.type = type;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
