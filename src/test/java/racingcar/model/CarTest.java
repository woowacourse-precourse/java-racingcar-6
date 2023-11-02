package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.car.Car;
import racingcar.model.movepolicy.MovePolicy;

class CarTest {
    private final int MOVING_DISTANCE = 1;

    private MovePolicy movePolicy;

    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"})
    void 자동차는_정해진_정책에_부합해야_움직인다(boolean returnIsMoveable, int result) {
        movePolicy = () -> returnIsMoveable;
        Car car = new Car("테스트");
        int currentPosition = car.getPosition();

        car.move(MOVING_DISTANCE, movePolicy);

        assertThat(car.getPosition() - currentPosition).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,5,true", "5,7,false"})
    void 자동차끼리_같은_위치에_있는지_비교할_수_있다(int positon1, int positon2, boolean result) {
        Car car1 = new Car("테스트1", positon1);
        Car car2 = new Car("테스트2", positon2);

        boolean isSamePosition = car1.isSamePosition(car2);

        assertThat(isSamePosition).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,6,두번째","5,3,첫번째","5,5,두번째"})
    void 자동차끼리_비교하여_더_멀리_이동한_차량을_구할수_있다(int position1,int position2,String keyCarName) {
        Car car1 = new Car("첫번째", position1);
        Car car2 = new Car("두번째", position2);
        Map<String, Car>  carMap = Map.of(car1.getName(), car1, car2.getName(), car2);

        Car maxCar = Car.maxByPostion(car1, car2);
        //만약 값이 같을 경우 두번째 파라미터의 자동차를 리턴한다.

        assertThat(maxCar).isEqualTo(carMap.get(keyCarName));
    }
}