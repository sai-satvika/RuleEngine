package src;

public class Node {
    public enum NodeType { OPERAND, OPERATOR }
    
    NodeType type;
    Node left;
    Node right;
    String value; // Optional value for operands or operators

    public Node(NodeType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Node(NodeType type, String value, Node left, Node right) {
        this.type = type;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
