package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    private Judgement judgement = new Judgement();

    @Test
    @DisplayName("전진한 위치가 같다면, 모두 우승")
    void 전진위치_같으면_모두우승() {
        List<Car> cars = List.of(
                new Car("hyeongil"),
                new Car("hyeongil2"),
                new Car("hyeongil3")
        );
        List<Winner> winners = judgement.judgeGameResult(cars);

        assertThat(winners)
                .isEqualTo(List.of(
                        new Winner("hyeongil"),
                        new Winner("hyeongil2"),
                        new Winner("hyeongil3")));
    }

    @Test
    @DisplayName("전진한 위치가 다르다면, 선두 자동차 우승")
    void 전진위치_다르면_선두자동차_우승() {

        Car car1 = new Car("hyeongil");
        Car car2 = new Car("hyeongil2");
        Car car3 = new Car("hyeongil3");
        car1.forward(5);

        List<Car> cars = List.of(
                car1,
                car2,
                car3
        );
        List<Winner> winners = judgement.judgeGameResult(cars);

        assertThat(winners)
                .isEqualTo(List.of(new Winner("hyeongil")));
    }


}