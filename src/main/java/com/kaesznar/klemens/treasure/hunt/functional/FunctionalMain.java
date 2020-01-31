package com.kaesznar.klemens.treasure.hunt.functional;

import com.kaesznar.klemens.treasure.hunt.oo.Clue;
import com.kaesznar.klemens.treasure.hunt.oo.TreasureMap;
import com.kaesznar.klemens.treasure.hunt.util.TreasureHuntUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FunctionalMain {

  public static void main(String[] args) throws IOException {
    //fake input stream can be used to not have to manually input the data.
    fakeInputStream();

    int[][] treasureMapInput = TreasureHuntUtil.readTreasureMapFromStdin(5);



    System.out.println(TreasureHunt.startRecursiveHunt(treasureMapInput,11));
    System.out.println("---");
    System.out.println(TreasureHunt.startRecursiveHunt(treasureMapInput,11));
    System.out.println("---");
    System.out.println(TreasureHunt.startRecursiveHunt(treasureMapInput,11));
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
