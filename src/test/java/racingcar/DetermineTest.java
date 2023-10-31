package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Determine;

public class DetermineTest {
  private List<String> carNames;
  private List<String> go;

  @BeforeEach
  void setup() {
    carNames = new ArrayList<>();
    go = new ArrayList<>();

    carNames.add("car1");
    carNames.add("car2");
    carNames.add("car3");
  }

  @Test
  void 우승자한명일때() {
    go.add("-");
    go.add("--");
    go.add("---");

    String result = Determine.winner(go, carNames);
    assertThat(result).isEqualTo("최종 우승자 : car3");
  }

  @Test
  void 우승자여러명일때() {
    go.add("-");
    go.add("---");
    go.add("---");

    String result = Determine.winner(go, carNames);
    assertThat(result).isEqualTo("최종 우승자 : car2, car3");
  }

  @Test
  void 우승자여러명쉼표구분확인() {
    go.add("-");
    go.add("---");
    go.add("---");

    String result = Determine.winner(go, carNames);
    assertThat(result).contains(",");
  }
}
