package racingcar.domainTest;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingProcess;


public class RacingProcessTest {

  @Test
  void 자동차목록을_받아서_진행도를_출력하는_기능_검사() {
    RacingProcess race = new RacingProcess();
    ArrayList<Car> carLineUp = new ArrayList<>();
    List<String> names = List.of("pobi", "minju", "woni");
    List<Integer> progress = List.of(1, 2, 0);
    List<String> results = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      carLineUp.add(new Car(names.get(i), progress.get(i)));
    }
    for (int i = 0; i < carLineUp.size(); i++) {
      results.add(race.makingStatusBar(carLineUp.get(i)));
    }

    assertThat(results.get(0)).isEqualTo("pobi : -");
    assertThat(results.get(1)).isEqualTo("minju : --");
    assertThat(results.get(2)).isEqualTo("woni : ");
  }
}
