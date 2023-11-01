package racingcar.input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.service.RacingGameService;

public class InputTest {
    private final RacingGameService racingGameService = new RacingGameService();

    private final CarRepository carRepository = new CarRepository();
    @Test
    void 차량_중복_입력값_검사() {
        Car testCar = new Car("1");
        carRepository.addCar(testCar);

        assertThat(carRepository.isCarIn("1"));

    }
    @Test
    void 차량_입력값_크기_초과_검사(){
        // 길이 5이상의 경우
        assertThrows(IllegalArgumentException.class, () -> {
            racingGameService.inputParser("123456,1234");
        });
    }
    @Test
    void 차량_입력값_크기_0_검사(){
        assertThrows(IllegalArgumentException.class, () -> {
            racingGameService.inputParser(",1234");
        });
    }

    @Test
    void 시도_회수_입력값_음수_검사(){
        assertThrows(IllegalArgumentException.class, () -> {
            racingGameService.attemptParseToInt("-1");
        });

    }
    @Test
    void 시도_회수_Stirng_입력값_검사(){
        assertThrows(IllegalArgumentException.class, () -> {
            racingGameService.attemptParseToInt("[[p[p");
        });

    }


}
