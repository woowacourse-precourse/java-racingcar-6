package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ExceptionMessage.DUPLICATED_CAR_NAME;
import static racingcar.constant.ExceptionMessage.INVALID_TRIAL_NUMBER;
import static racingcar.constant.ExceptionMessage.LENGTH_OUT_OF_RANGE_CAR_NAME;
import static racingcar.constant.ExceptionMessage.NOT_ALLOWED_WORDS_CAR_NAME;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @Test
    void convertCarNames_정상_입력() {
        String carNamesWithSeparator = "pobi,woni,jun";
        List<String> carNames = InputHandler.convertCarNames(carNamesWithSeparator);

        String name1 = carNames.get(0);
        String name2 = carNames.get(1);
        String name3 = carNames.get(2);
        int carNamesLength = carNames.size();

        assertThat(carNamesLength).isEqualTo(3);
        assertThat(name1).isEqualTo("pobi");
        assertThat(name2).isEqualTo("woni");
        assertThat(name3).isEqualTo("jun");
    }

    @Test
    void convertCarNames_글자수_예외처리() {
        String carNamesWithSeparator = "pobi,woninja,jun";

        assertThatThrownBy(() -> InputHandler.convertCarNames(carNamesWithSeparator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_OUT_OF_RANGE_CAR_NAME);
    }

    @Test
    void convertCarNames_중복_이름_예외처리() {
        String carNamesWithSeparator = "pobi,pobi,jun";

        assertThatThrownBy(() -> InputHandler.convertCarNames(carNamesWithSeparator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_CAR_NAME);
    }

    @Test
    void convertCarNames_특수문자_이름_형식_오류_예외처리() {
        String carNamesWithAt = "pobi,wo@ni,jun";

        assertThatThrownBy(() -> InputHandler.convertCarNames(carNamesWithAt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_WORDS_CAR_NAME);
    }

    @Test
    void convertCarNames_공백_이름_형식_오류_예외처리() {
        String carNamesWithSpace = "pobi, woni, jun";

        assertThatThrownBy(() -> InputHandler.convertCarNames(carNamesWithSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_WORDS_CAR_NAME);
    }

    @Test
    void convertTrialNumber_한자리수_정상_입력() {
        String trialNumOfSingleDigit = "5";

        int resultOfSingleDigit = InputHandler.convertTrialNumber(trialNumOfSingleDigit);

        assertThat(resultOfSingleDigit).isEqualTo(5);
    }

    @Test
    void convertTrialNumber_두자리수_정상_입력() {
        String trialNumOfTwoDigit = "10";

        int resultOfTwoDigit =  InputHandler.convertTrialNumber(trialNumOfTwoDigit);

        assertThat(resultOfTwoDigit).isEqualTo(10);
    }

    @Test
    void convertTrialNumber_0_입력_예외처리() {
        String trialNumZero = "0";

        assertThatThrownBy(() -> InputHandler.convertTrialNumber(trialNumZero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TRIAL_NUMBER);
    }

    @Test
    void convertTrialNumber_음수_입력_예외처리() {
        String trialNumNegative = "-1";

        assertThatThrownBy(() -> InputHandler.convertTrialNumber(trialNumNegative))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TRIAL_NUMBER);
    }

    @Test
    void convertTrialNumber_문자_입력_예외처리() {
        String trialNumChar = "a";

        assertThatThrownBy(() -> InputHandler.convertTrialNumber(trialNumChar))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TRIAL_NUMBER);
    }
}