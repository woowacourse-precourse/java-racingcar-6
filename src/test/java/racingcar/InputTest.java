package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void 이름_갯수에_대한_예외처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123,ABC", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표_기준으로_Split_함수_테스트(){
        List<String> names;
        MakeNames makeNames = new MakeNames();

        names = makeNames.commaSplit("123,abc,ABC");

        assertThat(names).isEqualTo(new ArrayList<>(Arrays.asList("123","abc","ABC")));
    }

    @Test
    void 이름_작성_기준_예외처리(){
        IntegrityCheck integrityCheck = new IntegrityCheck();

        // 이름의 길이에 대한 예외처리
        assertThat(integrityCheck.nameIntegrityCheck("123456")).isEqualTo(true);
        // 이름이 없는 것에 대한 예외처리
        assertThat(integrityCheck.nameIntegrityCheck("")).isEqualTo(true);
        // 이름에 제어 문자가 들어간 것에 대한 예외처리
        assertThat(integrityCheck.nameIntegrityCheck((char)(0) + "123")).isEqualTo(true);
    }

    @Test
    void 문자열_입력이_없는_경우_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수_문자열_무결성_검사_예외처리(){
        IntegrityCheck integrityCheck = new IntegrityCheck();

        assertThat(integrityCheck.intIntegrityCheck("00000123456789")).isEqualTo(false);
        assertThat(integrityCheck.intIntegrityCheck("123!456A7890")).isEqualTo(true);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
