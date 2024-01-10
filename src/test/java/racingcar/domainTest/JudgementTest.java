package racingcar.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;
import racingcar.domain.Judgement;

public class JudgementTest extends NsTest {

  public static final int LENGTH_OF_CARS = 3;

  @Test
  void 우승자를_가리는_기능() {
    Judgement judgement = new Judgement();
    List<Car> carLineUp = new ArrayList<>();
    List<String> cars = List.of("pobi", "minju", "java");
    List<Integer> progress = List.of(1, 2, 1);

    for (int i = 0; i < LENGTH_OF_CARS; i++) {
      carLineUp.add(new Car(cars.get(i), progress.get(i)));
    }
    List<String> winners = judgement.judgeWinner(carLineUp);

    assertThat(winners).containsExactly("minju");
  }

  @Test
  void 공동우승자를_가리는_기능() {
    Judgement judgement = new Judgement();
    List<Car> carLineUp = new ArrayList<>();
    List<String> cars = List.of("pobi", "minju", "java");
    List<Integer> progress = List.of(1, 2, 2);

    for (int i = 0; i < LENGTH_OF_CARS; i++) {
      carLineUp.add(new Car(cars.get(i), progress.get(i)));
    }
    List<String> winners = judgement.judgeWinner(carLineUp);

    assertThat(winners).containsExactly("minju", "java");
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}

