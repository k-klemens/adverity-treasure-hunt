package com.kaesznar.klemens.treasure.hunt.oo;

import com.kaesznar.klemens.treasure.hunt.util.TreasureHuntUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreasureMapTest {

  private TreasureMap treasureMapWithTreasureAt13;
  private String treasureMapWithTreasureAt13History = "1 1\n1 2\n1 3";

  private TreasureMap treasureMapWithTreasureAt55;
  private String treasureMapWithTreasureAt55History = "3 3\n1 5\n2 5\n3 1\n5 5";

  private TreasureMap treasureMapWithTreasureAt43;
  private String treasureMapWithTreasureAt43History = "1 1\n5 5\n1 5\n2 1\n4 4\n3 2\n1 3\n2 5\n4 3";

  private TreasureMap treasureMapWithOutOfBoundsClues;

  private TreasureMap treasureMapWithCircle;


  @BeforeEach
  public void beforeEach() throws IOException {
    String stringMapWithTreasureAt13Fixture = "12 13 13 41 25" + '\n' +
        "14 42 43 14 31" + '\n' +
        "54 45 52 42 23" + '\n' +
        "33 15 51 31 35" + '\n' +
        "21 52 33 13 23";

    InputStream fakeIn = new ByteArrayInputStream(stringMapWithTreasureAt13Fixture.getBytes());
    System.setIn(fakeIn);
    treasureMapWithTreasureAt13 = new TreasureMap(TreasureHuntUtil.readTreasureMapFromStdin(5));

    String stringMapWithTreasureAt55Fixture = "12 13 13 41 25" + '\n' +
        "14 42 43 14 31" + '\n' +
        "55 45 15 42 23" + '\n' +
        "33 15 51 31 35" + '\n' +
        "21 52 33 13 55";
    fakeIn = new ByteArrayInputStream(stringMapWithTreasureAt55Fixture.getBytes());
    System.setIn(fakeIn);
    treasureMapWithTreasureAt55 = new TreasureMap(TreasureHuntUtil.readTreasureMapFromStdin(5));

    String stringMapWithTreasureAt43Fixture = "55 14 25 52 21" + '\n' +
        "44 31 11 53 43" + '\n' +
        "24 13 45 12 34" + '\n' +
        "42 22 43 32 41" + '\n' +
        "51 23 33 54 15";
    fakeIn = new ByteArrayInputStream(stringMapWithTreasureAt43Fixture.getBytes());
    System.setIn(fakeIn);
    treasureMapWithTreasureAt43 = new TreasureMap(TreasureHuntUtil.readTreasureMapFromStdin(5));

    String treasureMapWithOutOfBoundsCluesFixture = "55 14 25 52 21" + '\n' +
        "44 31 11 53 43" + '\n' +
        "24 13 45 12 34" + '\n' +
        "42 22 69 32 41" + '\n' +
        "51 23 33 54 15";
    fakeIn = new ByteArrayInputStream(treasureMapWithOutOfBoundsCluesFixture.getBytes());
    System.setIn(fakeIn);
    treasureMapWithOutOfBoundsClues = new TreasureMap(TreasureHuntUtil.readTreasureMapFromStdin(5));

    String treasureMapWithCircleFixture = "55 14 25 52 21" + '\n' +
        "44 31 11 53 43" + '\n' +
        "24 13 45 12 34" + '\n' +
        "42 22 11 32 41" + '\n' +
        "51 23 33 54 15";
    fakeIn = new ByteArrayInputStream(treasureMapWithCircleFixture.getBytes());
    System.setIn(fakeIn);
    treasureMapWithCircle = new TreasureMap(TreasureHuntUtil.readTreasureMapFromStdin(5));
  }

  @Test
  public void testDoHunt_givenTreasureMapWithTreasureAt13_ExpectRightHistory(){
    String computedHistory = treasureMapWithTreasureAt13.doHunt(new Clue(11));
    Assertions.assertEquals(treasureMapWithTreasureAt13History, computedHistory);
  }

  @Test
  public void testDoHunt_givenTreasureMapWithTreasureAt55_ExpectRightHistory(){
    String computedHistory = treasureMapWithTreasureAt55.doHunt(new Clue(33));
    Assertions.assertEquals(treasureMapWithTreasureAt55History, computedHistory);
  }

  @Test
  public void testDoHunt_givenTreasureMapWithTreasureAt43_ExpectRightHistory(){
    String computedHistory = treasureMapWithTreasureAt43.doHunt(new Clue(11));
    Assertions.assertEquals(treasureMapWithTreasureAt43History, computedHistory);
  }

  @Test
  public void testDoHunt_givenTreasureMapWithOutOfBoundsClues_ExpectException(){
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> treasureMapWithOutOfBoundsClues.doHunt(new Clue(11)));
  }

  @Test
  public void testDoHunt_givenTreasureMapWithCircle_ExpectNoTreasure(){
    Assertions.assertEquals("NO TREASURE", treasureMapWithCircle.doHunt(new Clue(11)));
  }
}
