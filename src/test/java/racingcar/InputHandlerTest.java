package racingcar;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.InputHandler.getInteger;
import static racingcar.InputHandler.initCars;

public class InputHandlerTest {
    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void initCars_정상입력_오류없음() {
        setInput("A,B,C");

        List<Car> ret = initCars();

        assertThat(ret).extracting(Car::getName)
                .containsExactly("A", "B", "C");
    }

    @Test
    void initCars_콤마가연속_오류발생() {
        setInput("A,,B");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> initCars());
    }

    @Test
    void initCars_5글자초과가포함_오류발생() {
        setInput("ABCDEF,ABC");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> initCars());
    }


    @Test
    void getInteger_숫자입력_오류없음() {
        setInput("1");
        Assertions.assertDoesNotThrow(() -> getInteger());
    }

    @Test
    void getInteger_문자입력_오류발생() {
        setInput("A");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> getInteger());
    }

    @Test
    void getInteger_소수입력_오류발생() {
        setInput("1.2");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> getInteger());
    }
}