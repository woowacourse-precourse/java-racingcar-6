package racingcar;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void Car_정상_객체생성() {
        String carName = "pobi"; //4자

        //정상 Car객체 생성 테스트
        Car newCar1 = new Car(carName);
        assertThat(newCar1).isNotNull();
        assertThat(newCar1.getCarName()).isEqualTo(carName);
    }

    @Test
    void Car_5자초과_객체생성() {
        String carName = "oliver"; //6자
        //5자 초과의 길이를 가진 객체 생성 시도 테스트
        assertThatThrownBy(()-> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car name must be no more than 5 characters.");
    }
}
