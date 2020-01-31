package com.kaesznar.klemens.treasure.hunt.oo;

import com.kaesznar.klemens.treasure.hunt.util.TreasureHuntUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OOMain {

  public static void main(String[] args) throws IOException {
    //fake input stream can be used to not have to manually input the data.
    fakeInputStream();

    int[][] treasureMapInput = TreasureHuntUtil.readTreasureMapFromStdin(5);

    TreasureMap treasureMap = new TreasureMap(treasureMapInput);

    System.out.println(treasureMap.doHunt(new Clue(11)));
    System.out.println("---");
    System.out.println(treasureMap.doHunt(new Clue(15)));
    System.out.println("---");
    System.out.println(treasureMap.doHunt(new Clue(55)));
  }

  public static void fakeInputStream() {
    String input = "34 21 32 41 25" + '\n' +
        "14 42 43 14 31" + '\n' +
        "54 45 52 42 23" + '\n' +
        "33 15 51 31 35" + '\n' +
        "21 52 33 13 23";
    InputStream fakeIn = new ByteArrayInputStream(input.getBytes());
    System.setIn(fakeIn);
  }

}
