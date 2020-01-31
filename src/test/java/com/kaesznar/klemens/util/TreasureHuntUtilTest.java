package com.kaesznar.klemens.util;

import com.kaesznar.klemens.treasure.hunt.util.TreasureHuntUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreasureHuntUtilTest {

  String nonIntegerStringMap = "34 21 32 41 25" + '\n' +
      "14 42 43 14 31" + '\n' +
      "54 45 kk 42 23" + '\n' +
      "33 15 51 31 35" + '\n' +
      "21 52 33 13 23";

  String correctStringMapFixture = "34 21 32 41 25" + '\n' +
      "14 42 43 14 31" + '\n' +
      "54 45 52 42 23" + '\n' +
      "33 15 51 31 35" + '\n' +
      "21 52 33 13 23";

  int[][] correctIntMapFixture = new int[][]{
      {34, 21, 32, 41, 25},
      {14, 42, 43, 14, 31},
      {54, 45, 52, 42, 23},
      {33, 15, 51, 31, 35},
      {21, 52, 33, 13, 23}
  };


  @Test
  public void testGetRowClue_givenTwoDigitNumber_ExpectTensDigit() {
    Assertions.assertEquals(1, TreasureHuntUtil.getRowClue(12));
  }

  @Test
  public void testGetRowClue_givenOneigitNumber_ExpectZero() {
    Assertions.assertEquals(0, TreasureHuntUtil.getRowClue(1));
  }

  @Test
  public void testGetColumnClue_givenTwoDigitNumber_ExpectUnitDigit() {
    Assertions.assertEquals(2, TreasureHuntUtil.getColumnClue(12));
  }

  @Test
  public void testGetColumnClue_givenOneDigitNumber_ExpectUnitDigit() {
    Assertions.assertEquals(2, TreasureHuntUtil.getColumnClue(2));
  }

  @Test
  public void testReadTreasureMapFromStdin_givenCorrectStringMap_ExpectCorrect2DIntArray()
      throws IOException {
    //given - faking the input stream
    InputStream fakeIn = new ByteArrayInputStream(correctStringMapFixture.getBytes());
    System.setIn(fakeIn);

    int[][] treasureMap = TreasureHuntUtil.readTreasureMapFromStdin(5);
    Assertions.assertArrayEquals(correctIntMapFixture, treasureMap);
  }

  @Test
  public void testReadTreasureMapFromStdin_givenNonIntegerStringMap_ExpectNumberFormatException()
      throws IOException {
    //given - faking the input stream
    InputStream fakeIn = new ByteArrayInputStream(nonIntegerStringMap.getBytes());
    System.setIn(fakeIn);

    Assertions.assertThrows(NumberFormatException.class, () -> {
      TreasureHuntUtil.readTreasureMapFromStdin(5);
    });
  }



}
