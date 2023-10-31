package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Print;

public class PrintTest {
  private List<String> carNames;
  private List<String> go;

  @BeforeEach
  void setup() {
    carNames = new ArrayList<>();
    go = new ArrayList<>();

    carNames.add("jdh");
    carNames.add("woni");
    carNames.add("pobi");

    for (int i = 0; i < carNames.size(); i++) {
      go.add("");
    }
  }

  @Test
  void 자동차이름출력확인() {
    String result = Print.printExecute(carNames, go);
    assertThat(result).contains("jdh", "woni", "pobi");
  }
}
