package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {

  @Test
  void makeCarList_입력받은_값을_리스트로_반환() {
    List<Car> resultList = Game.makeCarList("pobi,woni,jun");

    assertThat(resultList).extracting("name")
        .contains("pobi", "woni", "jun");
  }

  @Test
  void printTrialResult_출력_테스트() {
    List<Car> resultList = Game.makeCarList("pobi,woni,jun");
    resultList.get(0).addForwardDistance();
    resultList.get(0).addForwardDistance();
    resultList.get(1).addForwardDistance();
    resultList.get(1).addForwardDistance();
    resultList.get(1).addForwardDistance();
    resultList.get(2).addForwardDistance();

    OutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    Game.printTrialResult(resultList);
    System.setOut(System.out);

    assertEquals("pobi : --\r\nwoni : ---\r\njun : -\r\n\r\n", out.toString());
  }
}
