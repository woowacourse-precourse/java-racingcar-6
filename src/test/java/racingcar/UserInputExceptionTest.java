package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserInputExceptionTest {

    private UserInputException userInputException;

    @BeforeEach
    void 기본_설정_셋팅() {
        userInputException = new UserInputException();
    }

    @Test
    void 자동차_이름_중복_검사() {
        String[] carNames = {"Car1", "Car2", "Car1"};

        assertThrows(IllegalArgumentException.class, () -> userInputException.validateUniqueCarName(carNames));
    }

    @Test
    void 자동차_이름_공백_검사_1() {
        String[] carNames = {"Car1", "Car 2", "Car3"};

        assertThrows(IllegalArgumentException.class, () -> userInputException.validateBlankCarName(carNames));
    }

    @Test
    void 자동차_이름_공백_검사_2() {
        String[] carNames = {"Car1", " Car2", "Car3"};

        assertThrows(IllegalArgumentException.class, () -> userInputException.validateBlankCarName(carNames));
    }

    @Test
    void 자동차_이름_공백_검사_3() {
        String[] carNames = {"Car1", "Car2", " "};

        assertThrows(IllegalArgumentException.class, () -> userInputException.validateBlankCarName(carNames));
    }

    @Test
    void 자동차_이름_길이_검사() {
        String[] carNames = {"Car1", "Car1232331231"};

        assertThrows(IllegalArgumentException.class, () -> userInputException.validateCarNameLength(carNames));
    }

    @Test
    void 자동차_이름_빈칸_검사() {
        String[] carNames = {"Car1", ""};

        assertThrows(IllegalArgumentException.class, () -> userInputException.validateEmptyCarName(carNames));
    }

    @Test
    void 자동차_이름_개수_검사() {
        String[] carNames = {"Car1"};

        assertThrows(IllegalArgumentException.class, () -> userInputException.validateSingleCarName(carNames));
    }

    @Test
    void 시도_횟수가_Integer형으로_변환_가능한지_검사() {
        String userInput = "이것은 숫자가 아닙니다.";

        assertThrows(IllegalArgumentException.class, () -> userInputException.isIntegerAttemptCount(userInput));
    }

    @Test
    void 시도_횟수가_최소_시도_횟수보다_큰_수인지_검사() {
        int attemptCount = 0;

        assertThrows(IllegalArgumentException.class, () -> userInputException.validateAttemptCountRange(attemptCount));
    }
}
