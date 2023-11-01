package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.game.TextResourceManager.GAME_STAGE_VIEW_HEADER;
import static racingcar.game.TextResourceManager.INPUT_NAMES_TEXT;
import static racingcar.game.TextResourceManager.INPUT_TRIAL_TEXT;

import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("애플리케이션이 요구사항대로 출력되고 있는지 테스트")
public class Application_OutputTest extends MyApplicationTest {

    @Test
    void 게임_시작_직후에_자동차_이름_입력_문구_출력() {
        run("pobi,woni", "10");
        assertThat(outputs())
                .first()
                .isEqualTo(INPUT_NAMES_TEXT);

    }

    @Test
    void 자동차_이름_입력_문구와_시도할_횟수_입력_문구_출력() {
        run("pobi,woni", "10");
        assertThat(outputs())
                .contains(INPUT_NAMES_TEXT, INPUT_TRIAL_TEXT);
    }

    @Test
    void 실행결과를_출력() {
        run("pobi,woni", "10");
        assertThat(outputs())
                .contains(GAME_STAGE_VIEW_HEADER);
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
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{1,5} : -*");
        run("pobi,woni", "10");
        assertThat(outputs())
                .filteredOn(output -> pattern.matcher(output).matches())
                .hasSize(2 * 10);
    }

}
