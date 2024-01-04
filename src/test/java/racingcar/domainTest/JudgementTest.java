package racingcar.domainTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;
import racingcar.domain.Judgement;

public class JudgementTest extends NsTest {
    @Test
    void 우승자를_가리는_기능() {
        Judgement judgement = new Judgement();
        ArrayList<Car> carListSoloWin = new ArrayList<>();
        ArrayList<Car> carListDuoWin = new ArrayList<>();
        ArrayList<String> cars = new ArrayList<>(Arrays.asList("pobi", "minju", "java"));
        ArrayList<Integer> progressSoloWin = new ArrayList<>(Arrays.asList(1, 2, 1));
        ArrayList<Integer> progressDuoWin = new ArrayList<>(Arrays.asList(1, 2, 2));

        for (int i = 0; i < 3; i++) {
            carListSoloWin.add(new Car(cars.get(i), progressSoloWin.get(i)));
            carListDuoWin.add(new Car(cars.get(i), progressDuoWin.get(i)));
        }

        String result = judgement.judgeWinner(carListSoloWin);
        assertThat(result).contains("minju");

        result = judgement.judgeWinner(carListDuoWin);
        assertThat(result).contains("minju", "java");

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

