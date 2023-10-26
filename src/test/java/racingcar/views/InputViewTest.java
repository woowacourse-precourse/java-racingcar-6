package racingcar.views;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

        List<String> carnameList = InputView.getCarnameList(normal);
        assertThat(carnameList.size()).isEqualTo(5);
        assertThat(carnameList).isNotNull();

        assertThrows(CarNameIncorrectException.class, () -> {
            InputView.getCarnameList(emptyError);
        });

        assertThrows(CarNameSizeLimitExceededException.class, () -> {
            InputView.getCarnameList(sizeError);
        });


    }

}