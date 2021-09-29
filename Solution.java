import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<List<String>> squareWords(String[] wordsList) {
    List<List<String>> result = new ArrayList<List<String>>();
    Map<Integer, HashMap<String, Integer>> groupOfSize = new HashMap<>();
    
    HashMap<String, Integer> group;
    int length;
    for (String word : wordsList) {
      length = word.length();
      group = groupOfSize.getOrDefault(length, new HashMap<>());
      group.put(word, group.getOrDefault(word, 0) + 1);
      groupOfSize.put(length, group);
    }
    
    for (Map.Entry<Integer, HashMap<String, Integer>> entry : groupOfSize.entrySet()) {
      squareSize(entry.getKey(), entry.getValue(), result);
    }
    
    return result;
  }

  public void squareSize(int size, Map<String,Integer> words,
                         List<List<String>> res) {
    List<String> sol = new ArrayList<>();
    explore(words, res, sol, size);
  }

  public void explore(Map<String, Integer> words, List<List<String>> res,
                      List<String> sol, int size) {
    if (sol.size() == size) {
      res.add(new ArrayList<>(sol));
    } else {
      int remaining;
      String candidate;
      String prefix = getPrefix(sol);
      for (Map.Entry<String, Integer> word : words.entrySet()) {
        remaining = word.getValue();
        if (remaining > 0) {
          candidate = word.getKey();
          words.put(candidate, remaining - 1);
          if (candidate.startsWith(prefix)) {
            sol.add(candidate);
            explore(words, res, sol, size);
            sol.remove(sol.size() - 1);
          }
          words.put(candidate, remaining);
        }
      }
    }
  }

  private String getPrefix(List<String> sol) {
    StringBuilder prefix = new StringBuilder();
    int len = sol.size();
    for (String prev : sol) {
      prefix.append(prev.charAt(len));
    }
    return prefix.toString();
  }
}