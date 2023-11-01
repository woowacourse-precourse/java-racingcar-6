package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CarTest {
    @Test
    void condition이_FORWARD_CONDITION_NUMBER와_같거나_크면_전진하여_position이_1_증가한다() {
        String carName = "pobi";
        Car car = new Car(carName);

        int initialPosition = car.getPosition(); //초기 위치
        int condition = Car.FORWARD_CONDITION_NUMBER;

        // Act
        car.forwardOrStay(condition);

        // Assert
        int expectedPosition = initialPosition + 1;
        assertEquals(car.getPosition(), expectedPosition);
    }

    @Test
    void condition이_FORWARD_CONDITION_NUMBER보다_작으면_position에_변함이_없다() {
        String carName = "pobi";
        Car car = new Car(carName);

        int initialPosition = car.getPosition(); //초기 위치
        int condition = Car.FORWARD_CONDITION_NUMBER - 1;

        // Act
        car.forwardOrStay(condition);

        // Assert
        int expectedPosition = initialPosition;
        assertEquals(car.getPosition(), expectedPosition);
    }
    @Test
    void carName의_길이가_6이면_IllegalArgumentException_에러를_던진다() {
        String carName = "123456";

        assertThrows(IllegalArgumentException.class, () -> {
            new Car(carName);
        });
    }
    @Test
    void carName의_길이가_6이면_메소드명_checkCarNameLengthValid_에서_에러를_던진다() {
        String carName = "123456";
        String methodName = "checkCarNameLengthValid";

        try{
            new Car(carName);
        }catch (IllegalArgumentException e){
            String throwsFromMethod = e.getStackTrace()[0].getMethodName();
            assertEquals(throwsFromMethod, methodName);
        }
    }

    @Test
    void carName이_null이면_IllegalArgumentException_에러를_던진다() {
        String carName = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Car(carName);
        });
    }

    @Test
    void carName이_null이면_메소드명_checkCarNameEmpty_에서_에러를_던진다() {
        String carName = null;
        String methodName = "checkCarNameEmpty";

        try{
            new Car(carName);
        }catch (IllegalArgumentException e){
            String throwsFromMethod = e.getStackTrace()[0].getMethodName();
            assertEquals(throwsFromMethod, methodName);
        }
    }
    @Test
    void carName이_공백이면_IllegalArgumentException_에러를_던진다() {
        String carName = "";

        assertThrows(IllegalArgumentException.class, () -> {
            new Car(carName);
        });
    }

    @Test
    void carName이_공백이면_메소드명_checkCarNameEmpty_에서_에러를_던진다() {
        String carName = "";
        String methodName = "checkCarNameEmpty";

        try{
            new Car(carName);
        }catch (IllegalArgumentException e){
            String throwsFromMethod = e.getStackTrace()[0].getMethodName();
            assertEquals(throwsFromMethod, methodName);
        }
    }

    @Test
    void carName에_whitespace가_포함되면_IllegalArgumentException_에러를_던진다() {
        String carName = "po bi";

        assertThrows(IllegalArgumentException.class, () -> {
            new Car(carName);
        });
    }

    @Test
    void carName이_whitespace가_포함되면_메소드명_checkCarNameContainsWhiteSpace_에서_에러를_던진다() {
        String carName = "po bi";
        String methodName = "checkCarNameContainsWhiteSpace";

        try{
            new Car(carName);
        }catch (IllegalArgumentException e){
            String throwsFromMethod = e.getStackTrace()[0].getMethodName();
            assertEquals(throwsFromMethod, methodName);
        }
    }


}