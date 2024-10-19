package src;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RuleEngine engine = new RuleEngine();
        engine.createRule("x > 5");
        engine.createRule("y < 10");
        engine.createRule("z == 15");

        Map<String, Object> data = new HashMap<>();
        data.put("x", 6);
        data.put("y", 9);
        data.put("z", 15);

        System.out.println(engine.evaluateRule("x > 5", data)); // true
        System.out.println(engine.evaluateRule("y < 10", data)); // true
        System.out.println(engine.evaluateRule("z == 15", data)); // true
    }
}
