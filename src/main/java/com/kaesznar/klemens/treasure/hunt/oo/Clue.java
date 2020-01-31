package com.kaesznar.klemens.treasure.hunt.oo;

import com.kaesznar.klemens.treasure.hunt.util.TreasureHuntUtil;

public class Clue {

  private int nextRowClue;
  private int nextColumnClue;

  public Clue(int clueNumber) {
    this.nextRowClue = TreasureHuntUtil.getRowClue(clueNumber);
    this.nextColumnClue = TreasureHuntUtil.getColumnClue(clueNumber);
  }

  public Clue(int nextRowClue, int nextColumnClue) {
    this.nextRowClue = nextRowClue;
    this.nextColumnClue = nextColumnClue;
  }

  public int getNextRowClue() {
    return nextRowClue;
  }

  public int getNextColumnClue() {
    return nextColumnClue;
  }

  @Override
  public String toString() {
    return nextRowClue + " " + nextColumnClue;
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
    return getNextRowClue() == clue.getNextRowClue() &&
        getNextColumnClue() == clue.getNextColumnClue();
  }

}
