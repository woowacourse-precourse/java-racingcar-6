package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class Application_OutputTest extends MyApplicationTest {

    private static final String INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIALS = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";

    @Test
    void 게임_시작_직후에_자동차_이름_입력_문구_출력() {
        run("pobi,woni", "10");
        assertThat(outputs())
                .first()
                .isEqualTo(INPUT_NAMES);

    }

    @Test
    void 자동차_이름_입력_문구와_시도할_횟수_입력_문구_출력() {
        run("pobi,woni", "10");
        assertThat(outputs())
                .contains(INPUT_NAMES, INPUT_TRIALS);
    }

    @Test
    void 실행결과를_출력() {
        run("pobi,woni", "10");
        assertThat(outputs())
                .contains(EXECUTION_RESULT);
    }

    @Test
    void 중간_결과를_시행횟수번_출력한다() {
        run("pobi,woni", "10");
        assertThat(outputs())
                .filteredOn(output -> output.contains("pobi :"))
                .hasSize(10);
    }

    @Test
    void 각_자동차별_실행결과를_시행횟수번_출력한다() {
        Pattern pattern = Pattern.compile("\\w{1,5} :");
        run("pobi,woni", "10");
        assertThat(outputs())
                .filteredOn(output -> pattern.matcher(output).matches())
                .hasSize(2 * 10);
    }

}
