package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void Cars_정상_생성() {
        // given
        String names = "a,bb,ccc,dddd";

        // when
        Cars cars = Cars.from(names);

        // then
        assertThat(cars.getCars().size()).isEqualTo(4);
    }

    @Test
    void Cars_비정상_생성() {
        // given
        String names = "a,bb,ccc,dddddd";

        // when then
        assertThatThrownBy(() -> Cars.from(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Cars_비정상_생성_이름없음() {
        // given
        String nameZero = ", ";

        // when then
        assertThatThrownBy(() -> Cars.from(nameZero))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 우승자_이름_추출() {
        // given
        Cars cars = Cars.from("a,b,c,d,e");
        int n = 10;

        // when
        while(n-- > 0) {
            cars.go();
        }


        // then
        Car maxCar = cars.getCars()
                .stream()
                .max(Comparator.comparing(Car::getPosition)).get();

        assertThat(cars.findWinnerNameList())
                .contains(maxCar.getName());
    }

    @Test
    void 공동_우승자_추출() {
        // given
        Cars cars = Cars.from("a,b,c,d,e");
        int n = 10;

        // when
        while(n-- > 0) {
            cars.go();
        }


        // then
        Integer maxPosition = cars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max().getAsInt();

        List<String> carList = cars.getCars()
                .stream().filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.getName())
                .toList();

        assertThat(cars.findWinnerNameList())
                .isEqualTo(carList);
    }
}