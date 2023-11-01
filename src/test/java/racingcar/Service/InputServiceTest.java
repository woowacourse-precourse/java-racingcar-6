package racingcar.Service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputServiceTest {
    InputService inputService;
    String name;

    @BeforeEach
    public void init() {
        //given
        inputService = new InputService();
        name = "pobi,woni,jun";
        inputService.SplitCarname(name);
    }

    @Test
    @DisplayName("자동차의 이름은 , 으로 구별하여 입력한다.")
    public void Input1() {
        name = "pobi,woni,jun";

        //then
        assertThat(inputService.inputCarname(name)).isEqualTo(name);
        assertThat(inputService.SplitCarname(name)).contains("pobi", "woni", "jun");
        assertThat(inputService.getCarNames().get(0)).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차의 이름은 5자리로 입력하는 판별기능")
    public void Input2() {

        name = "pobi,woni,JUUUUN";
        assertThat(inputService.valideFivename(name)).isFalse();

    }

    @Test
    @DisplayName("사용자는 시도할 횟수를 입력하는 기능")
    public void Input3() {
        String tryNum = "5";
        assertThat(inputService.inputTryNum(tryNum)).isEqualTo("5");
    }

    @Test
    @DisplayName("사용자가 잘못된 값을 입력할 경우 IllegalArugmentException 발생기능")
    public void Input4() {
        name = "pobi,woni,JUUUUN";
        name = "pobi,woni,JUUUUN";
        assertThatThrownBy(() -> inputService.throwException(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("split한 이름으로 Car 객체 배열 생성")
    public void input5() {
        assertThat(inputService.makeCarArray().size())
                .isEqualTo(3);
    }
}
