package racingcar.firstclasscollection;

import java.util.HashMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;
import racingcar.model.Car;

class PositionMapTest {

    @Test
    public void 자동차_중복_등록_예외() throws Exception {
        //given
        PositionMap positionMap = new PositionMap(HashMap::new);

        //when
        Car car1 = new Car("car1");

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    positionMap.putCar(car1);
                    positionMap.putCar(car1);
                }).withMessage(ExceptionMessage.CAR_NAME_DUPLICATED);
    }

    @Test
    public void 우승자가_한_명일_때() {
        //given
        PositionMap positionMap = new PositionMap(HashMap::new);
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        putCars(positionMap, car1, car2, car3);

        //when
        moveCarNth(positionMap, car1, 5);
        moveCarNth(positionMap, car2, 3);
        moveCarNth(positionMap, car3, 3);

        //then
        List<Car> winners = positionMap.getWinners();
        Assertions.assertThat(winners)
                .containsExactly(car1);
    }

    @Test
    public void 우승자가_여러_명일_때() {
        //given
        PositionMap positionMap = new PositionMap(HashMap::new);
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        putCars(positionMap, car1, car2, car3);

        //when
        moveCarNth(positionMap, car1, 5);
        moveCarNth(positionMap, car2, 5);
        moveCarNth(positionMap, car3, 3);

        //then
        List<Car> winners = positionMap.getWinners();
        Assertions.assertThat(winners)
                .containsExactlyInAnyOrder(car1, car2);
    }

    private void putCars(PositionMap positionMap, Car... cars) {
        for (Car car : cars) {
            positionMap.putCar(car);
        }
    }

    private void moveCarNth(PositionMap positionMap, Car car, int n) {
        for (int i = 0; i < n; i++) {
            positionMap.moveCar(car);
        }
    }
}