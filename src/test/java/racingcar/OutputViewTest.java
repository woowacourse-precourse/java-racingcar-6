package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.output.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OutputViewTest extends NsTest {

    @Test
    void 경주할_자동차_이름을_입력하세요_출력() {
        OutputView.printRequestMultipleCarName();
        assertThat(output()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 시도할_횟수는_몇회인가요_출력() {
        OutputView.printRequestTryCount();
        assertThat(output()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    void 실행_결과_출력() {
        OutputView.printExecuteResult();
        assertThat(output()).isEqualTo("실행 결과");
    }

    @CsvSource({ "pobi, -, 'pobi : -'",
            "jun, ---, 'jun : ---'",
            "pobi, -----, 'pobi : -----'" })
    @ParameterizedTest
    void 자동차명_현재_이동위치_출력(String carName, String carDistance, String expected) {
        OutputView.printFormatStatus(carName, carDistance);
        assertThat(output()).isEqualTo(expected);
    }

    @CsvSource({ "woni, '', 'woni : '" })
    @ParameterizedTest
    void 자동차명_현재_이동위치_0일경우_빈_값_출력(String carName, String carDistance, String expected) {
        OutputView.printFormatStatus(carName, carDistance);
        assertThat(output()).contains(expected);
    }

    @CsvSource({ "pobi, '최종 우승자 : pobi'",
            "woni, '최종 우승자 : woni'",
            "'pobi, jun', '최종 우승자 : pobi, jun'",
            "'pobi, jun, woni','최종 우승자 : pobi, jun, woni'" })
    @ParameterizedTest
    void 최종_우승자_출력(String winner, String expected) {
        OutputView.printFormatFinalWinner(winner);
        assertThat(output()).isEqualTo(expected);
    }

    @Override
    protected void runMain() {
    }

}
