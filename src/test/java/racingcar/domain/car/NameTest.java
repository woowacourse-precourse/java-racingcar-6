package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @DisplayName("이름에 공백이 있다면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {""," "," jun","jun ","j un","ju n"})
    void 이름에_공백이_들어갈_때_예외_발생_테스트(String name) {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }

    @DisplayName("이름의 길이가 1~5자가 아니라면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"","junseo","junseopark"})
    void 유효하지_않은_이름_길이_예외_발생_테스트(String name) {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }

    @DisplayName("이름이 영어 또는 한글이 아닌 문자가 포함하면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"jun1","ju-n","!j!","^^","123"})
    void 영어_및_한글_제외_문자_포함_예외_발생_테스트(String name) {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }

    @DisplayName("올바른 이름은 예외가 발생하지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"jun","박jun","jun팍","박준서"})
    void 올바른_이름_테스트(String name) {
        //when, then
        assertDoesNotThrow(() -> new Name(name));
    }

    @Test
    void 이름_반환_테스트() {
        //given
        Name name = new Name("jun");

        //when
        String target = name.toString();

        //then
        assertThat(target).isEqualTo("jun");
    }
}
