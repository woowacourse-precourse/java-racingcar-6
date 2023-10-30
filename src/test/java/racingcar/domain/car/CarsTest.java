package racingcar.domain.car;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 이름이_5자_이하인_정상_객체_추가() {
        Cars cars = new Cars();

        cars.addCar("pobi");
        Car car = cars.getCar(0);

        Assertions.assertThat(car.getCarName()).isEqualTo("pobi");
    }

    @Test
    void 이름이_5자_초과인_이상객체_추가() {
        Cars cars = new Cars();
        Assertions.assertThatThrownBy(() -> cars.addCar("CapPobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 모든_객체_리스트_반환() {
        Cars cars = new Cars();
        cars.addCar("pobi");
        cars.addCar("woni");
        cars.addCar("jun");

        List<Car> allCars = cars.getAllCars();
        Assertions.assertThat(allCars.size()).isEqualTo(3);
    }
}