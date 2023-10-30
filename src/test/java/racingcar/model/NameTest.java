package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    void 이름_입력_성공_테스트() {
        String nameValue = "name";
        Name name = new Name(nameValue);
        assertThat(name.value()).isEqualTo(nameValue);
    }

    @Test
    void 길이_제한_못_미치는_이름_실패_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1글자 이상 5글자 이하의 이름을 입력해주세요."));
    }

    @Test
    void 길이_제한_넘는_이름_실패_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Name("namename"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1글자 이상 5글자 이하의 이름을 입력해주세요."));
    }

    @Test
    void 공배_있는_이름_실패_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Name("na me"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름에 공백이 없도록 입력해주세요."));
    }

    @Test
    void 중복_이름_테스트() {
        List<Name> nameList = List.of(new Name("name"), new Name("NAME"), new Name("name"));
        assertSimpleTest(() -> assertThatThrownBy(() -> Name.validateDuplicateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름을 입력하셨습니다."));
    }
}