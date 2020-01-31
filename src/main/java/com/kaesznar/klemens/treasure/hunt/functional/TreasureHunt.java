package com.kaesznar.klemens.treasure.hunt.functional;

import com.kaesznar.klemens.treasure.hunt.util.TreasureHuntUtil;

public class TreasureHunt {

  /**
   * Performs the treasure hunt starting with a given Clue using a recursive approach.
   *
   * @param treasureMap a two-dimensional integer array containing the treasure map.
   * @param firstClue a two digitNumber representing the first clue.
   * @return the history of the visited fields if there is a treasure otherwise NO TREASURE is
   * returned.
   */
  public static String startRecursiveHunt(int[][] treasureMap, int firstClue) {
    //extracting the start index from the given firstClue
    int currentRow = TreasureHuntUtil.getRowClue(firstClue);
    int currentColumn = TreasureHuntUtil.getColumnClue(firstClue);
    //get the information to the next clue
    int currentClue = treasureMap[currentRow - 1][currentColumn - 1];
    //extract the information from the given clue
    int nextRowClue = TreasureHuntUtil.getRowClue(currentClue);
    int nextColumnClue = TreasureHuntUtil.getColumnClue(currentClue);

    //start the recursion
    return startRecursiveHunt(treasureMap, currentRow, currentColumn, nextRowClue, nextColumnClue,
        new StringBuilder());
  }

  /**
   * Actual recursive hunt which uses a StringBuilder to build the history.
   *
   * @param treasureMap a two-dimensional integer array containing the treasure map.
   * @param currentRow the current row which is being added to the history.
   * @param currentColumn the current column which is being added to the history.
   * @param nextRowClue the next row clue which will be processed.
   * @param nextColumnClue the next column clue which will be processed.
   * @param historyBuilder a StringBuilder object which keeps track of the history. Is also used to
   * detect circular searches.
   * @return the history of the visited fields if there is a treasure otherwise NO TREASURE is
   * returned.
   */
  private static String startRecursiveHunt(int[][] treasureMap, int currentRow, int currentColumn,
      int nextRowClue, int nextColumnClue, StringBuilder historyBuilder) {

    if (historyBuilder.toString().contains(nextRowClue + " " + nextColumnClue)) {
      return "NO TREASURE";
    }

    historyBuilder.append(currentRow + " " + currentColumn).append("\n");

    //if -> break the recursion because the nextClue and CurrentClue are the same
    if (currentRow == nextRowClue && currentColumn == nextColumnClue) {
      return historyBuilder.toString().trim();
    }

    //getting the next clue
    int currentClue = treasureMap[nextRowClue - 1][nextColumnClue - 1];
    //setting the nextClue as the currentClue for the next recursion step
    //and get the new nextClues from the treasure map
    return startRecursiveHunt(treasureMap, nextRowClue, nextColumnClue,
        TreasureHuntUtil.getRowClue(currentClue), TreasureHuntUtil.getColumnClue(currentClue),
        historyBuilder);
  }

}
