package com.kaesznar.klemens.treasure.hunt.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Treasure map holding a two-dimensional array of clues and providing the methods to hunt the
 * treasure.
 */
public class TreasureMap {

  private Clue[][] clueMap;

  public TreasureMap(int[][] treasureMap) {
    this.clueMap = new Clue[treasureMap.length][treasureMap[0].length];
    for (int i = 0; i < clueMap.length; i++) {
      for (int j = 0; j < clueMap[i].length; j++) {
        clueMap[i][j] = new Clue(treasureMap[i][j]);
      }
    }
  }

  /**
   * Performs the treasure hunt starting with a given Clue.
   *
   * @param startClue the clue where to start searching from.
   * @return the history of the fields visited if there is a treasure otherwise NO TREASURE.
   */
  public String doHunt(Clue startClue) {
    List<Clue> clueHistory = new ArrayList<>();
    clueHistory.add(startClue);

    Clue currentClue = startClue;
    Clue nextClue = clueMap[currentClue.getRowClue() - 1][currentClue.getColumnClue() - 1];

    while (!(currentClue.equals(nextClue))) {
      currentClue = nextClue;
      nextClue = clueMap[currentClue.getRowClue() - 1][currentClue.getColumnClue() - 1];

      //if -> to avoid if there are circular clues to be followed
      if (clueHistory.contains(currentClue)) {
        return "NO TREASURE";
      } else {
        clueHistory.add(currentClue);
      }
    }

    return clueHistory.stream().map(Clue::toString).collect(Collectors.joining("\n"));
  }

}
