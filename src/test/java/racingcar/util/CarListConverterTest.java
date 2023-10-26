package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.car.Car;

import java.util.List;

class CarListConverterTest {

    @Test
    @DisplayName("자동차의 이름을 가진 문자열을 이용해서 자동차가 담긴 리스트로 변환할 수 있다.")
    public void convertStringArrayToCarList() {
        // given
        String[] names = new String[]{"pobi","pobi","pobi"};
        // when
        List<Car> cars = CarListConverter.convertStringArrayToCarList(names);
        // then
        cars.forEach(System.out::println);
    }

}