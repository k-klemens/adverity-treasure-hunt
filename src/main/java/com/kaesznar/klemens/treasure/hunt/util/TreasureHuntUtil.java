package com.kaesznar.klemens.treasure.hunt.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreasureHuntUtil {

  /**
   * Util method to take a tow digit int and get to get the ten's digit representing the row of the
   * next clue.
   *
   * @param clue two digit int.
   * @return the ten's digit, even the digit has less than two digits zero is returned.
   */
  public static int getRowClue(int clue) {
    return clue / 10;
  }

  /**
   * Util method to take a tow digit int and get to get the unit's digit representing the column of
   * the next clue.
   */
  public static int getColumnClue(int clue) {
    return clue % 10;
  }


  /**
   *
   * Reads a given number of lines from Stdin where each lines contains five space separated integers.
   * @param rowCount number of rows to read.
   * @return a two-dimensional int-array containing the given integer numbers
   * @throws IOException
   * @throws NumberFormatException if a given input cannot be parsed to int.
   */
  public static int[][] readTreasureMapFromStdin(int rowCount)
      throws IOException, NumberFormatException {
    int[][] treasueMap = new int[rowCount][];
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    try {
      for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
        String inputLine = bufferedReader.readLine();
        String[] splittedInput = inputLine.split(" ");

        int[] row = Arrays.stream(splittedInput).mapToInt(Integer::parseInt).toArray();
        treasueMap[rowIndex] = row;
      }
    } catch (IOException e) {
      System.out.println("IOException occurred when reading from STDIN the input");
      throw e;
    } catch (NumberFormatException e) {
      System.out.println("NumberFormatException occurred when parsing the input");
      throw e;
    }
    return treasueMap;
  }


}
