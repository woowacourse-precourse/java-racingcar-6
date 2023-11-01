package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputSystemTest {
    private InputSystem inputSystem;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        inputSystem = new InputSystem();
        cars = new ArrayList<>();
    }

    @Test
    void 잘못된_자동차_이름_입력() {
        try {
            inputSystem.nameValidator("A,B,", cars);
        } catch (IllegalArgumentException e){

        }
    }

    @Test
    void 올바른_자동차_이름_입력() {
        try {
            inputSystem.nameValidator("car1,car2,car3", cars);
        } catch (IllegalArgumentException e){

        }
    }

    @Test
    void 숫자가_아닌_문자_입력() {
        try {
            inputSystem.cntValidator("12A");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void 올바른_숫자_입력() {
        inputSystem.cntValidator("123");
    }
}