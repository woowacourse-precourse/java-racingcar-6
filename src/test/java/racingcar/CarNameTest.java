package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    public void 자동차이름_빈값() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해 주세요.");
    }

    @Test
    public void 자동차이름_널() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해 주세요.");
    }

    @Test
    public void 자동차이름_다섯글자초과() {
        assertThatThrownBy(() -> new CarName("ㅁㄴㅇㅁㄴㄴ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    public void 자동차이름_공백(){
        assertThatThrownBy(() -> new CarName(" "))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
