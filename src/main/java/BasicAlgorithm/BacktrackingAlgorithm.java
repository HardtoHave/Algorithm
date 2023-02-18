package BasicAlgorithm;

import java.util.*;

public class BacktrackingAlgorithm {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        BacktrackingAlgorithm generator = new BacktrackingAlgorithm();
        List<List<Integer>> permutations = generator.generatePermutation(elements);
        System.out.println(permutations);
    }
    public List<List<Integer>> generatePermutation(List<Integer> elements){
        List<List<Integer>> permutations=new ArrayList<>();
//        boolean[] used = new boolean[elements.size()];
//        Collections.sort(elements); // Sort the input list
        backtrack(permutations,new ArrayList<>(),elements);
        return permutations;
    }
    private void backtrack(List<List<Integer>> permutations, List<Integer> tempList, List<Integer> elements){
        if (tempList.size()==elements.size()){
            permutations.add(new ArrayList<>(tempList));
        }else {
            for (int i = 0; i < elements.size(); i++) {
                int element = elements.get(i);
                if (tempList.contains(element)){
                    continue;
                }
                tempList.add(elements.get(i));
                backtrack(permutations,tempList,elements);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
