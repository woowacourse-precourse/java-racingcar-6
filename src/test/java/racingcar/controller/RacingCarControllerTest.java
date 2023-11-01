package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCar;

public class RacingCarControllerTest {
    RacingCarController racingCarController =
            new RacingCarController("nana,dudu,rara", "5");

    @Test
    void 입력값_들어갔는지_확인() {
        List<RacingCar> racingCarList = racingCarController.racingCarList;

        assertThat(racingCarList.get(0).getCarName()).contains("nana");
        assertThat(racingCarList.get(1).getCarName()).contains("dudu");
        assertThat(racingCarList.get(2).getCarName()).contains("rara");
    }

    @Test
    void 자동차이름제한_예외처리() {
        assertThatThrownBy(() -> {
            RacingCarController racingCarController =
                    new RacingCarController("nanana", "5");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
