package view;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    InputView inputView;

    @BeforeEach
    void init(){
        inputView = new InputView();
    }

    @DisplayName("자동차 이름 입력값 유효성 검사")
    @ParameterizedTest
    @ValueSource(strings = {"잠온다,자고싶다", ",","라라", " ","   ","라라, ","여섯글자인데, 붕붕이"})
    void validateCarNamesTest(String carNames){
        Assertions.assertThatThrownBy(() -> assertThat(inputView.validateCarNames(carNames)).isTrue())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
