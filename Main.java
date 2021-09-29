import java.util.List;

class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    
    String[] wordsList = {"AREA", "BALL", "DEAR", "LADY", "LEAD", "YARD", "WALL", "MALL", "ABCD", "BCDE", "CDEF", "DEFG"};
    List<List<String>> squares = solution.squareWords(wordsList);
    System.out.println("Solutions: " + squares.size());
    for (List<String> square : squares) {
      for (String row : square) {
        System.out.println(row);
      }
      System.out.println();
    }
    /* TODO: Implement distributed system
    String[] hugeList = new String[100000];
    StringBuilder test = new StringBuilder();
    for (int i = 0; i < 1000; ++i) test.append("A");
    for (int i = 0; i < hugeList.length; i++) {
      hugeList[i] = test.toString();
    }
    List<List<String>> check = solution.squareWords(hugeList);
    System.out.println("Solutions: " + check.size());
    */
  }
}