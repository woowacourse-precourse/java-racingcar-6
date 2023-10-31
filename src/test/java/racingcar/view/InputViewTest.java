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
    public void validateAttemptTest() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            String attempt = "qwe";
            InputView inputView = new InputView();
            inputView.validateAttemptOnlyNumber(attempt);
        });
    }

}