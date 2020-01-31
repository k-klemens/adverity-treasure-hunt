package com.kaesznar.klemens.treasure.hunt.oo;

import com.kaesznar.klemens.treasure.hunt.util.TreasureHuntUtil;

/**
 * Class storing information of a clue.
 */
public class Clue {

  private int rowClue;
  private int columnClue;

  public Clue(int clueNumber) {
    this.rowClue = TreasureHuntUtil.getRowClue(clueNumber);
    this.columnClue = TreasureHuntUtil.getColumnClue(clueNumber);
  }

  public Clue(int rowClue, int columnClue) {
    this.rowClue = rowClue;
    this.columnClue = columnClue;
  }

  public int getRowClue() {
    return rowClue;
  }

  public int getColumnClue() {
    return columnClue;
  }

  @Override
  public String toString() {
    return rowClue + " " + columnClue;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (!(o instanceof Clue)) {
      return false;
    }
    Clue clue = (Clue) o;
    return getRowClue() == clue.getRowClue() &&
        getColumnClue() == clue.getColumnClue();
  }

}
