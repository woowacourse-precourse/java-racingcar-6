package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.Forward;
import racingcar.util.Parser;

class RacingCarTest {

    Parser parser;
    Forward forward;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        parser = new Parser();
        forward = new Forward();
    }

    @Test
    void parseCarNames_메소드로_주어진_값을_구분() {
        List<Car> cars = new ArrayList<>();
        String input = "a,b";
        List<String> carNames = parser.parseCarNames(input);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        assertThat(carNames).contains("b", "a");
        assertThat(carNames).containsExactly("a", "b");
    }

    @Test
    void parseNumberOfTrial_메소드로_주어진_값을_int로_변환() {
        String input = "5";
        int result = parser.parseNumberOfTrial(input);
        assertEquals(5, result);
    }

    @Test
    void 무작위_값_생성_테스트() {
        int randomNumber = forward.generateRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}
