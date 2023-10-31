package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    private RacingGame racingGame = new RacingGame();
    private final static String commaString = ",";

    private static List<String> convertStringToList(String carNames) {
        return Arrays.stream(carNames.split(commaString))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @DisplayName(",를 입력받으면 오류가 발생한다.")
    @Test
    void inputOneCommaString(){
        List<String> carNames = convertStringToList(",");
        assertThatThrownBy(() -> racingGame.setCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NO_CAR_NAME_MESSAGE.getExceptionMessage());
    }

    @DisplayName("빈 값을 입력받으면 오류가 발생한다.")
    @Test
    void inputEmptyString(){
        List<String> carNames = convertStringToList("");
        assertThatThrownBy(() -> racingGame.setCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE.getExceptionMessage());
    }

    @DisplayName("공백 문자를 포함한 자동차 이름 목록을 입력받으면 오류가 발생한다.")
    @Test
    void inputBlankCarNames(){
        List<String> carNames = convertStringToList("tomas, ,emily");
        assertThatThrownBy(() -> racingGame.setCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE.getExceptionMessage());
    }

    @DisplayName("유효한 길이를 가지지 않은 자동차 이름 목록을 입력받으면 오류가 발생한다.")
    @Test
    void inputWrongLengthOfCarNames(){
        List<String> carNames = convertStringToList("tomas,emily,spiderMan");
        assertThatThrownBy(() -> racingGame.setCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE.getExceptionMessage());
    }

    @DisplayName("1보다 작은 시도 횟수 값을 입력하면 오류가 발생한다.")
    @Test
    void inputUnderOneTryCount(){
        int tryCount = 0;
        assertThatThrownBy(() -> racingGame.setTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_WRONG_RANGE_OF_COUNT_MESSAGE.getExceptionMessage());
    }
}
