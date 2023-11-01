package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingcar.model.RacingCarService;
import racingcar.model.car.Car;

public class RacingCarTest {
    @Mock
    private RacingCarService service = new RacingCarService((minBound, maxBound) -> 4);

    @Test
    void 자동차는_4이상일때_전진한다() {
        Car car1 = new Car("a", 0, (minBound, maxBound) -> 3);
        car1.move();
        assertThat(car1.getPosition()).isEqualTo(0);

        Car car2 = new Car("b", 0, (minBound, maxBound) -> 4);
        car2.move();
        assertThat(car2.getPosition()).isEqualTo(1);
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
