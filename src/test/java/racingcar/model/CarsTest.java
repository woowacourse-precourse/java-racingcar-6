package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.enums.Common;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    // TODO : Cars에서는 어떤걸 입력시 잘못된 값일지 고민해보기
    @Test
    void 잘못된_입력_테스트() {
//        assertThatThrownBy(() -> new Cars("pobi,pobi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Cars() {
        new Cars("isaac,han");
    }

    @Test
    void everyCarMoveForward_false() {
        Cars cars = new Cars("isaac,han");
        assertRandomNumberInRangeTest(() -> {
            cars.everyCarMoveForward();
            assertThat(cars.getCarList().stream().allMatch(car -> car.getDistance().equals("-"))).isFalse();
        }, Common.STANDARD_NUMBER.getIntValue() - 1, Common.STANDARD_NUMBER.getIntValue());
    }

    @Test
    void everyCarMoveForward() {
        Cars cars = new Cars("isaac,han");
        assertRandomNumberInRangeTest(() -> {
            cars.everyCarMoveForward();
//            boolean flag = true;
//            for(Car car : cars.getCarList()) {
//                if(!car.getDistance().equals("-")) {
//                    flag = false;
//                    break;
//                }
//            }
//            assertThat(flag).isTrue();
            assertThat(cars.getCarList().stream().allMatch(car -> car.getDistance().equals("-"))).isTrue();
        }, Common.STANDARD_NUMBER.getIntValue(), Common.STANDARD_NUMBER.getIntValue());
    }

    @Test
    void getCarList() {
        String namesInput = "isaac,han";
        Cars cars = new Cars(namesInput);
//        boolean flag = true;
//        for(Car car : cars.getCarList()) {
//            if(!namesInput.contains(car.getName()))
//                flag = false;
//        }
//        assertThat(flag).isTrue();
        assertThat(cars.getCarList().stream().anyMatch(car -> namesInput.contains(car.getName()))).isTrue();
    }
}