package model;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("List<Cars> 생성 잘 되는지 테스트")
    void Cars_생성자_테스트() {
        //given
        List<Car> carList = List.of(
                new Car(new Name("pobi"), new MovingCount(0)),
                new Car(new Name("lisa"), new MovingCount(0)),
                new Car(new Name("jiny"), new MovingCount(0))
        );

        //when, then
        Assertions.assertThatCode(() -> {
            Cars cars = new Cars(carList);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("가장 큰 movingCount를 가진 Car객체의 이름 반환 테스트")
    void 가장_큰_movingCount_Car_객체_테스트() {
        //given
        Car pobiCar = new Car(new Name("pobi"), new MovingCount(0));
        Car lisaCar = new Car(new Name("lisa"), new MovingCount(0));
        Car jinyCar = new Car(new Name("jiny"), new MovingCount(0));
        lisaCar.increaseMovingCountIfGreater(4, 5);

        List<Car> carList = new ArrayList<>();
        carList.add(pobiCar);
        carList.add(lisaCar);
        carList.add(jinyCar);

        Cars cars = new Cars(carList);
        //when
        List<Car> maxMovingCountName = cars.findCarsWithMaxMovingCount();

        //then
        Assertions.assertThat(maxMovingCountName).isEqualTo(List.of(lisaCar));
    }

    @Test
    @DisplayName("갖고 있는 모든 Car객체의 상태 반환")
    void 모든_Car_객체_상태_반환_테스트() {
        //given
        List<Car> carList = new ArrayList<>();
        Car pobiCar = new Car(new Name("pobi"), new MovingCount(0));
        Car lisaCar = new Car(new Name("lisa"), new MovingCount(0));
        Car jinyCar = new Car(new Name("jiny"), new MovingCount(0));
        pobiCar.increaseMovingCountIfGreater(4, 5);
        lisaCar.increaseMovingCountIfGreater(4, 5);
        carList.add(pobiCar);
        carList.add(lisaCar);
        carList.add(jinyCar);
        Cars cars = new Cars(carList);

        //when
        String carsStatus = cars.getAllCarsStatus();

        //then
        Assertions.assertThat(carsStatus).isEqualTo("pobi : -\nlisa : -\njiny : \n");
    }
}
