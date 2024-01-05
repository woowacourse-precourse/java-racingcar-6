package racingcar.domainTest;


import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingProcess;
import racingcar.domain.Car;


public class RacingProcessTest {

    @Test
    void 자동차목록을_받아서_진행도를_출력하는_기능_검사() {
        RacingProcess race = new RacingProcess();
        List<Car> carList = new ArrayList<>();
        List<String> names = new ArrayList<>(List.of("pobi", "minju", "woni"));
        List<Integer> progress = new ArrayList<>(List.of(1, 2, 0));
        List<String> results;

        for (int i = 0; i < 3; i++) {
            carList.add(new Car(names.get(i), progress.get(i)));
        }
        results = new ArrayList<>(carList.size());
        for (int i = 0; i < results.size(); i++) {
            results.add(i, race.makingStatusBar(carList.get(i)));
        }

        assertThat(results.get(0)).contains("pobi : -");
        assertThat(results.get(1)).contains("minju : --");
        assertThat(results.get(2)).contains("woni : ");
    }
}
