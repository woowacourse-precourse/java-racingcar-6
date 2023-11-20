package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {
    private Judge judge;

    @BeforeEach
    void setUp() {
        this.judge = new Judge();
    }

    @DisplayName("첫번째 차량만 이동시켜 우승자 확인")
    @Test
    void checkWinnerTest() {
        RacingCars racingCars = new RacingCars(List.of("asdf", "qwer"));
        racingCars.getCars().get(0).move(5);

        List<Car> expect = new ArrayList<>();
        expect.add(racingCars.getCars().get(0));

        assertThat(judge.getWinners(racingCars.getCars()))
                .isEqualTo(expect);
    }

    @DisplayName("차량 모두 이동시켜 중복 우승자 확인")
    @Test
    void checkWinnersTest() {
        RacingCars racingCars = new RacingCars(List.of("asdf", "qwer"));
        racingCars.getCars().get(0).move(5);
        racingCars.getCars().get(1).move(5);

        List<Car> expect = new ArrayList<>();
        expect.add(racingCars.getCars().get(0));
        expect.add(racingCars.getCars().get(1));

        assertThat(judge.getWinners(racingCars.getCars()))
                .isEqualTo(expect);
    }

}