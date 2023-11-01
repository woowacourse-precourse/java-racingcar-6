package racingcarName;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.Exception.RacingCarException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingcarNameTest extends NsTest {

    private RacingCarException racingCarException;

    @BeforeEach
    void setUp() {
        racingCarException = new RacingCarException();
    }


    @Test
    @DisplayName("자동차 이름 중복 일 경우 예외")
    void 이름에_대한_중복_예외_처리() {
        String str = "a,b,b";

        List<String> carName = List.of(str.split(","));

        assertThatThrownBy(() -> racingCarException.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 입력 시 예외")
    void 이름에_대한_공백_예외_처리() {

        String str = "";

        List<String> carName = List.of(str.split(","));

        assertThatThrownBy(() -> racingCarException.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6자 이상 시 예외")
    void 이름에_대한_길이_예외_처리() {

        String str = "java,javaaa,java";

        List<String> carName = List.of(str.split(","));

        assertThatThrownBy(() -> racingCarException.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

