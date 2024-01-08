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
    List<String> cars = Arrays.asList("pobi", "minju", "java");
    List<Integer> progress = Arrays.asList(1, 2, 1);
    List<String> winners;
    String result;

    for (int i = 0; i < LENGTH_OF_CARS; i++) {
      carLineUp.add(new Car(cars.get(i), progress.get(i)));
    }

    winners = judgement.judgeWinner(carLineUp);
    result = String.join(", ", winners);
    assertThat(result).contains("minju");
  }

  @Test
  void 공동우승자를_가리는_기능() {
    Judgement judgement = new Judgement();
    List<Car> carLineUp = new ArrayList<>();
    List<String> cars = Arrays.asList("pobi", "minju", "java");
    List<Integer> progress = new ArrayList<>(Arrays.asList(1, 2, 2));
    List<String> winners;
    String result;

    for (int i = 0; i < LENGTH_OF_CARS; i++) {
      carLineUp.add(new Car(cars.get(i), progress.get(i)));
    }
    winners = judgement.judgeWinner(carLineUp);
    result = String.join(", ", winners);
    assertThat(result).contains("minju, java");
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}

