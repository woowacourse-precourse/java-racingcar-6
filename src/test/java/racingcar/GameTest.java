package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {

  @Test
  void makeCarList_입력받은_값을_리스트로_반환() {
    List<Car> resultList = Game.makeCarList("pobi,woni,jun");

    assertThat(resultList).extracting("name")
        .contains("pobi", "woni", "jun");
  }
}
