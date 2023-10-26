package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"banana", "potato", "pineapple"})
    @DisplayName("이름이 5글자 이상일 때 예외 발생하는지")
    public void 이름_5글자_이상_예외_테스트(String name) {
        //given
        String userInput = name;

        //when, then
        assertThatThrownBy(() -> new Name(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("미만이어야 합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"tree", "leaf", "sky"})
    @DisplayName("이름 정상적으로 할당 되는지")
    public void 이름_정상_테스트(String name) {
        //given
        String userInput = name;

        //when
        Name userName = new Name(userInput);

        //then
        assertThat(userName.getName()).isEqualTo(userInput);
    }
}
