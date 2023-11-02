package racingcar;

import domain.Car;
import domain.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class CarsTest {

    @Test
    void 같은_자동차_이름을_입력한_경우_예외처리_발생_테스트() {
        //given
        String userInput = "yoon,su,yoon";
        String[] carNames = userInput.split(",");
        Cars cars = new Cars(carNames);

        //when & then
        Assertions.assertThatThrownBy(()-> cars.validateDuplication())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 자동차 이름을 입력하였습니다. 애플리케이션을 종료합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"}, delimiter = ',')
    void 무작위_값이_4이상일_때_자동차를_전진시키는_기능_테스트(int number) {
        //given
        Car car = new Car("yoon");

        //when & then
        assertRandomNumberInRangeTest(() -> {
            car.moveAheadByRandomNumber();
            Assertions.assertThat(car.getProgress().getValue()).isEqualTo(1);
        }, number
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"}, delimiter = ',')
    void 모든_자동차를_무작위_값이_4이상일_때_전진시키는_기능(int number) {
        //given
        String userInput = "yoon,su";
        String[] carNames = userInput.split(",");
        Cars cars = new Cars(carNames);
        Car yoonCar = cars.getCars().get(0);
        Car suCar = cars.getCars().get(1);

        //when & then
        assertRandomNumberInRangeTest(() -> {
                    cars.moveAheadCars();
                    Assertions.assertThat(yoonCar.getProgress().getValue()).isEqualTo(1);
                    Assertions.assertThat(suCar.getProgress().getValue()).isEqualTo(1);
                }, number
        );
    }
}
