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

    @DisplayName("값 유무 검사")
    @ParameterizedTest
    @ValueSource(strings = {""," ",",","라라","''","라라, ","다   섯"})
    void isBlankTest(String data){
        Assertions.assertThatThrownBy(() -> assertThat(inputView.isBlank(data)).isTrue())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
