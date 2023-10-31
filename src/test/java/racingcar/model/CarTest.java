package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.CarDto;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 생성자는_전달받은_이름과_position_은_0으로_Car_객체를_생성한다(){
        Car car = new Car("자동차");
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("자동차");
    }

    @Test
    void toDto_메서드는_CarDto_객체를_생성한다() {
        Car car = new Car("자동차");
        CarDto carDto = car.toDto();
        assertThat(carDto.getName()).isEqualTo("자동차");
        assertThat(carDto.getPosition()).isEqualTo(0);
    }

    @Test
    void go_메서드는_position_을_증가시킨다() {
        Car car = new Car("자동차");
        car.go(true);
        CarDto carDto = car.toDto();

        assertThat(carDto.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"true, false, 1", "false, true, -1", "true, true, 0"})
    void compareTo_메서드는_자신과_다른_자동차_객체를_비교해_position_의_대소관계를_비교한다(boolean myCarMove, boolean compareCarMove, int result) {
        Car myCar = new Car("내자동차");
        Car compareCar = new Car("상대자동차");
        myCar.go(myCarMove);
        compareCar.go(compareCarMove);
        assertThat(myCar.compareTo(compareCar)).isEqualTo(result);
    }

    @Test
    void equals_메서드는_다른_Car_객체와_position_이_같은지_판별한다() {
        Car car = new Car("내자동차");
        Car compareCar = new Car("상대자동차");
        assertThat(car.equals(compareCar)).isTrue();
    }

}
