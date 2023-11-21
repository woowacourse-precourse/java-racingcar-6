package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

public class CarsTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi, pobi", "susu, wooi, susu"})
    @DisplayName("[ERROR] 자동차 이름을 중복해서 입력하였습니다. 중복하지 않도록 작성하세요.")
    void blank(String wrongInput) {
        InputView inputView = new InputView(() -> wrongInput);
        Assertions.assertThatThrownBy(() -> inputView.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
