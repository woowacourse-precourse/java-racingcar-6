package racingcar.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.message.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest extends NsTest {

    @Test
    @DisplayName("자동차 이름에 중복이 있으면 실패한다.")
    void validateCarNamesDuplicateTest() {
        //given
        List<String> carNames = new ArrayList<>(List.of("Test1", "Test1", "Test2"));

        //when && then
        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_DUPLICATE_NAME);

    }

    @Test
    @DisplayName("자동차 이름에 빈 칸이 있을 경우 실패한다.")
    void validateCarNamesEmptyTest() {
        //given
        List<String> carNames = new ArrayList<>(List.of("Test1", "", "Test3"));

        //when && then
        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_EMPTY_AND_BLANK);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과해서는 안된다.")
    void validateCarNamesGreaterThanFiveTest() {
        //given
        List<String> carNames = new ArrayList<>(List.of("TestTest1", "Test2", "Test3"));

        //when && then
        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MORE_THAN_FIVE);
    }

    @Test
    @DisplayName("사용자가 잘못된 횟수를 입력하면 실패한다.")
    void validateUserAnswer() {
        //given
        List<String> userAnswers = List.of("가나다", " 테스트", "0", "-5", "6.1");

        //when && then
        userAnswers.forEach(userAnswer ->
                assertThatThrownBy(() -> Validator.validateCarTrying(userAnswer))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionMessage.NOT_NATURAL_NUMBER)
        );
    }

    @Override
    protected void runMain() {
    }
}
