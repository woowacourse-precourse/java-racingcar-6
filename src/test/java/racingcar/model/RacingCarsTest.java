package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test
    void 자동차_입력_테스트() {

        RacingCars racingCars = new RacingCars();
        List<String> names = new ArrayList<>(Arrays.asList("첫번째", "두번째", "세번째"));

        racingCars.setCars(names);

        for(int i = 0; i < racingCars.getCars().size(); i++) {
            assertThat(names).contains(racingCars.getCars().get(i).getName());
        }
    }

    @Test
    void 우승자_입력_테스트() {

        RacingCars racingCars = new RacingCars();
        List<String> names = new ArrayList<>(Arrays.asList("첫번째", "두번째", "세번째"));

        racingCars.setWinners(names);

        for(int i = 0; i < racingCars.getCars().size(); i++) {
            assertThat(names).contains(racingCars.getWinners().get(i));
        }
    }
}
