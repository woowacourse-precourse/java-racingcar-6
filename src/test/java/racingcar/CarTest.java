package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource({"5, 1", "2, 0", "4, 1"})
    void 자동차_전진_기능_테스트(int randomNumber, int expectedPosition) {
        // given
        Car car = Car.from("test");

        // when
        car.moveForward(randomNumber);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @CsvSource({"4, true", "3, false"})
    void 우승자_여부_판단_기능_테스트(int iteration, boolean expectedResult) {
        // given
        int randomNumber = 5;
        int maxPosition = 4;
        Car car = Car.from("test");
        for (int i=0; i<iteration; i++) {
            car.moveForward(randomNumber);
        }

        // when
        boolean result = car.isWinner(maxPosition);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
