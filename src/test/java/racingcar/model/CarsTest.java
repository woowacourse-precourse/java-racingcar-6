package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void from_메서드로_사용자_입력을_기반으로_자동차_객체_정보를_업데이트() {
        List<String> carNameList = List.of("포비", "찬미", "뀨 뀨");
        Cars cars = Cars.from(carNameList);

        assertEquals(carNameList.get(0), cars.getCarList().get(0).getName());
        assertEquals(carNameList.get(1), cars.getCarList().get(1).getName());
        assertEquals(carNameList.get(2), cars.getCarList().get(2).getName());
    }

    @Test
    void getMaxPositionCars_메서드로_하나의_가장_멀리_간_자동차_리스트_반환() {
        Cars cars = Cars.from(List.of("포비", "찬미", "뀨 뀨"));

        Stream.iterate(1, round -> round + 1)
                .limit(5)
                .forEach(round -> cars.getCarList().get(0).move());
        Stream.iterate(1, round -> round + 1)
                .limit(4)
                .forEach(round -> cars.getCarList().get(1).move());
        Stream.iterate(1, round -> round + 1)
                .limit(3)
                .forEach(round -> cars.getCarList().get(2).move());

        List<Car> carList = cars.getMaxPositionCars();

        assertEquals(carList.size(), 1);
        assertEquals(carList.get(0).getName(), "포비");
    }

    @Test
    void getMaxPositionCars_메서드로_복수의_가장_멀리_간_자동차_리스트_반환() {
        Cars cars = Cars.from(List.of("포비", "찬미", "뀨 뀨"));

        Stream.iterate(1, round -> round + 1)
                .limit(5)
                .forEach(round -> cars.getCarList().get(0).move());
        Stream.iterate(1, round -> round + 1)
                .limit(5)
                .forEach(round -> cars.getCarList().get(1).move());
        Stream.iterate(1, round -> round + 1)
                .limit(5)
                .forEach(round -> cars.getCarList().get(2).move());

        List<Car> carList = cars.getMaxPositionCars();

        assertEquals(carList.size(), 3);
    }
}
