package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("이름 5자 이상일 경우 예외 발생 테스트")
    @Test
    public void validateCarNameTest() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] carName = {"pobipobi", "jiwoo"};
            InputView inputView = new InputView();
            inputView.validateCarName(carName);
        });
    }

    @DisplayName("시도 횟수가 숫자가 아닐경우 예외 발생 테스트")
    @Test
    public void validateAttemptOnlyNumberTest() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            String attempt = "qwe";
            InputView inputView = new InputView();
            inputView.validateAttemptOnlyNumber(attempt);
        });
    }

    @DisplayName("시도 횟수가 정상적인 숫자입력이 아닐경우 예외 발생 테스트")
    @Test
    public void validateAttemptNormalInputTest() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            int attempt = 0;
            InputView inputView = new InputView();
            inputView.validateAttemptNormalInput(attempt);
        });
    }

}