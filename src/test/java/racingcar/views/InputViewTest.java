package racingcar.views;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.exception.CarNameIncorrectException;
import racingcar.exception.CarNameSizeLimitExceededException;

class InputViewTest {

    @Test
    @DisplayName("Console readLine 테스트")
    void consoleREadLineTest() {
        String input = "입력 값 테스트";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = Console.readLine();

        assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("자동차 이름 입력 시 빈값, null 입력 시 예외 발생")
    void nullAndEmptyCheckTest() {

        String inputNull = null;
        String inputEmpty = "";
        String inputBlank = "  ";

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkNullAndEmpty(inputNull);
        });
        assertThrows(CarNameIncorrectException.class, () -> {
            InputView.checkNullAndEmpty(inputNull);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkNullAndEmpty(inputEmpty);
        });
        assertThrows(CarNameIncorrectException.class, () -> {
            InputView.checkNullAndEmpty(inputEmpty);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkNullAndEmpty(inputBlank);
        });
        assertThrows(CarNameIncorrectException.class, () -> {
            InputView.checkNullAndEmpty(inputBlank);
        });

    }

    @Test
    @DisplayName("자동차 이름 입력 시 , 으로 분리 및 자동차 이름 5자 이하 인지 확인")
    void carnameSplitAndNameSizeLimitTest() {

        String normal = "1,12,123,1234,12345";
        String emptyError = "123,1234,12345, ,";
        String sizeError = "1,12,123456";

        List<Car> carnameList = InputView.getCarnameList(normal);
        assertThat(carnameList.size()).isEqualTo(5);
        assertThat(carnameList).isNotNull();

        assertThrows(CarNameIncorrectException.class, () -> {
            InputView.getCarnameList(emptyError);
        });

        assertThrows(CarNameSizeLimitExceededException.class, () -> {
            InputView.getCarnameList(sizeError);
        });


    }

    @Test
    @DisplayName("도전 횟수 입력 받기 숫자 타입 체크")
    void tryCountInputAndNumberTypeCheckTest() {
        // 정상의 경우
        assertDoesNotThrow(() -> InputView.validateMovingCount("123"));

        // 비정상의 경우 예외 발생
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateMovingCount(" ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateMovingCount("1 3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateMovingCount(" a");
        });
        // 0 이하의 값 입려 시 예외 발생
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateMovingCount("0");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateMovingCount("-1");
        });
        // Integer Max 값 이상의 경우 예외 발생
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateMovingCount("2147483648");
        });
    }

}