package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 기능 구현 함수들 테스트
 */
public class MethodTest extends NsTest {


    @Test
    void 자동차_이름_입력_테스트() {
        // given
        String input = "pobi,woni";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        List<String> result = Application.inputCar();

        // then
        List<String> inputStringList = new ArrayList<>();
        String[] split = input.split(",");
        for(String data : split) {
            inputStringList.add(data);
        }
        assertThat(result).isEqualTo(inputStringList);
    }

    @Test
    void 자동차_이름_입력_예외_테스트() {
        // given
        String input = "5charmore15charmore2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(() -> Application.inputCar())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 경기_진행_횟수_입력_테스트() {
        // given
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int result = Application.inputRound();

        // then
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @Test
    void 경기_진행_횟수_입력_예외_테스트() {
        // given
        String input = "1c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(() -> Application.inputRound())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
