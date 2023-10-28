package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestUtils.generateName;
import static racingcar.enums.Constant.MAX_NAME_LENGTH;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 전진_불가_테스트() {
        //given
        // 예외 발생을 위해 허용 되는 수치에 1을 더함
        int length = MAX_NAME_LENGTH.getConstant() + 1;

        String name = generateName(length);
        Car car = new Car(name);

        boolean expectedResult = true;

        //when and then
        assertThat(car.isExceedMaxLength()).isEqualTo(expectedResult);
    }

    @Test
    void 전진_가능_테스트() {
        //given
        int length = MAX_NAME_LENGTH.getConstant();

        String name = generateName(length);
        Car car = new Car(name);

        boolean expectedResult = false;

        //when and then
        assertThat(car.isExceedMaxLength()).isEqualTo(expectedResult);
    }

    @Test
    void 전진_기능_작동_테스트() {
        //given
        Car car = new Car("Test");
        int expectedMoveCount = 1;

        //when
        car.moveForward();

        //then
        assertThat(car.getMoveCount()).isEqualTo(expectedMoveCount);
    }

}