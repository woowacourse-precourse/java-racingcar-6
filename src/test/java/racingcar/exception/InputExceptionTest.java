package racingcar.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputExceptionTest {


    private InputException inputException;

    @BeforeEach
    void setup() {
        inputException = new InputException();
    }

    @Test
    void 이름_예외처리_5자초과_케이스() {

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayList<String> carNameList = new ArrayList<>();
            carNameList.add("jungmin");
            inputException.checkCarNamesInputException(carNameList);
        });

    }

    @Test
    void 이름_예외처리_중복_케이스() {

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayList<String> carNameList = new ArrayList<>();
            carNameList.add("jung");
            carNameList.add("jung");
            inputException.checkCarNamesInputException(carNameList);
        });


    }

    @Test
    void 이름_예외처리_공백_케이스() {

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayList<String> carNameList = new ArrayList<>();
            carNameList.add("   ");
            inputException.checkCarNamesInputException(carNameList);
        });

    }

    @Test
    void 시도회수_예외처리_0이하일경우() {
        InputException inputException = new InputException();

        assertThrows(IllegalArgumentException.class, () -> {
            int attemptsCount = 0; // 1 미만의 회수
            inputException.checkAttemptsInputException(attemptsCount);
        });

    }
}
