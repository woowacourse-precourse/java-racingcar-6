package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    private final static String spaceString = " ";
    private final static String blankString = "";
    private final static String commaString = ",";
    private static List<String> convertStringToList(String carNames) {
        return Arrays.asList(carNames.replace(spaceString, blankString).split(commaString));
    }

    @DisplayName(",를 입력받으면 오류가 발생한다.")
    @Test
    void inputOneCommaString(){
        String carNames = ",";
        assertThatThrownBy(() -> new RacingGame(convertStringToList(carNames)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NO_CAR_NAME_MESSAGE.getExceptionMessage());
    }

    @DisplayName("빈 값을 입력받으면 오류가 발생한다.")
    @Test
    void inputEmptyString(){
        String carNames = "";
        assertThatThrownBy(() -> new RacingGame(convertStringToList(carNames)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE.getExceptionMessage());
    }

    @DisplayName("공백 문자를 포함한 자동차 이름 목록을 입력받으면 오류가 발생한다.")
    @Test
    void inputBlankCarNames(){
        String carNames = "tomas, ,emily";
        assertThatThrownBy(() -> new RacingGame(convertStringToList(carNames)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE.getExceptionMessage());
    }

    @DisplayName("유효한 길이를 가지지 않은 자동차 이름 목록을 입력받으면 오류가 발생한다.")
    @Test
    void inputWrongLengthOfCarNames(){
        String carNames = "tomas,emily,spiderMan";
        assertThatThrownBy(() -> new RacingGame(convertStringToList(carNames)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE.getExceptionMessage());
    }

    @DisplayName("중복된 자동차 이름 목록을 입력받으면 오류가 발생한다.")
    @Test
    void inputDuplicateCarNames(){
        String carNames = "tomas,emily,emily";
        assertThatThrownBy(() -> new RacingGame(convertStringToList(carNames)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_DUPLICATE_CAR_NAME_MESSAGE.getExceptionMessage());
    }

    @DisplayName("올바른 자동차 이름 목록을 입력받으면 성공한다")
    @Test
    void inputRightCarNames(){
        String carNames = "tomas,emily,james";
        RacingGame racingGame = new RacingGame(convertStringToList(carNames));
        assertThat(racingGame.getCars().size()).isEqualTo(3);
    }
}
