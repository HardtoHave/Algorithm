package BasicAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class EnumerationAlgorithm {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        EnumerationAlgorithm generator = new EnumerationAlgorithm();
        List<List<Integer>> combinations = generator.generateCombination(elements);
        System.out.println(combinations);
    }

    public List<List<Integer>> generateCombination(List<Integer> elements) {
        List<List<Integer>> combinations = new ArrayList<>();
        int n = elements.size();
        for (int i = 0; i < (1 << n); i++) { // Generate all 2^n possible combinations
            List<Integer> combination = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // Check if the jth bit of i is set to 1
                    combination.add(elements.get(j)); // Add the jth element to the combination
                }
            }
            combinations.add(combination); // Add the combination to the list of combinations
        }
        return combinations;
    }
}