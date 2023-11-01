package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    private RacingCarService service;

    @BeforeEach
    public void initializeService() {
        this.service = new RacingCarService(((minBound, maxBound) -> 4));
    }

    @Test
    void 전진_안한_자동차는_아무것도_출력하지_않는다() {
        //given
        String userInputCarNames = "a";
        service.createCarList(userInputCarNames);

        //when
        String racingResult = service.racingResult();

        //then
        assertThat(racingResult).contains("a : ");
    }

    @Test
    void 전진_후_결과_변환() {
        //given
        String userInput = "a";
        service.createCarList(userInput);

        //when
        service.move();//한 번만 전진
        String racingResult = service.racingResult();

        //then
        assertThat(racingResult).contains("a : -");
    }
}
