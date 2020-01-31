package com.kaesznar.klemens.treasure.hunt.oo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClueTest {

  private Clue clue11Fixture;
  private Clue clue12Fixture;
  private Clue clue12SecondFixture;

  @BeforeEach
  public void beforeEach() {
    clue11Fixture = new Clue(11);
    clue12Fixture = new Clue(12);
    clue12SecondFixture = new Clue(12);

  }

  @Test
  public void testClueConstructor_givenTwoDigitInteger_ExpectRightPopulatedClueObject() {
    Clue clue = new Clue(13);
    Assertions.assertEquals(clue.getRowClue(), 1);
    Assertions.assertEquals(clue.getColumnClue(), 3);
  }

  @Test
  public void testClueConstructor_givenSeparateRowAndColumn_ExpectRightPopulatedClueObject() {
    Clue clue = new Clue(1, 3);
    Assertions.assertEquals(clue.getRowClue(), 1);
    Assertions.assertEquals(clue.getColumnClue(), 3);
  }

  @Test
  public void testEquals_givenSameClueObjectReferences_ExpectTrue() {
    Assertions.assertTrue(clue11Fixture.equals(clue11Fixture));
  }

  @Test
  public void testEquals_givenSameClueObjectValues_ExpectTrue() {
    Assertions.assertTrue(clue12SecondFixture.equals(clue12Fixture));
  }

  @Test
  public void testEquals_givenDifferentClueObjects_ExpectFalse() {
    Assertions.assertFalse(clue11Fixture.equals(clue12Fixture));
  }

  @Test
  public void testEquals_givenStringObject_ExpectFalse() {
    Assertions.assertFalse(clue11Fixture.equals("test test test"));
  }

}
