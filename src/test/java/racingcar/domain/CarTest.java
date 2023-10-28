package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.TestUtils.generateName;
import static racingcar.enums.Constant.MAX_NAME_LENGTH;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 전진_불가_테스트() {
        //given
        // 예외 발생을 위해 허용 되는 수치에 1을 더함
        int length = MAX_NAME_LENGTH.getConstant() + 1;

        String name = generateName(length, 'a');
        Car car = new Car(name);

        boolean expectedResult = true;

        //when and then
        assertThat(car.isExceedMaxLength()).isEqualTo(expectedResult);
    }

    @Test
    void 전진_가능_테스트() {
        //given
        int length = MAX_NAME_LENGTH.getConstant();
        String name = generateName(length, 'a');
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

    @Test
    void Equals_테스트() {
        //given
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car1");

        //when and then
        assertTrue(car1.equals(car1));
        assertTrue(car1.equals(car3));
        assertTrue(car3.equals(car1));
        assertFalse(car1.equals(car2));
        assertFalse(car2.equals(car1));
    }

    @Test
    void hash_code_테스트() {
        //given
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car1");

        //when and then
        assertThat(car1.hashCode()).isEqualTo(car3.hashCode());
        assertThat(car1.hashCode()).isNotEqualTo(car2.hashCode());
    }
}