package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarOutputViewTest {
    private static final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(OUTPUT));
    }

    /**
     * - printStartMessage(): 실행 결과를 출력한다. - [ ] `"실행 결과"` 출력.
     * <p>
     * - printEachRacingResult(): `사용자가 입력한 횟수`만큼 각 차수별 실행 결과를 출력한다. - [ ] 경주할 자동차의 이름 순서에 맞게 `이름 : -` 형태로 출력. - [ ]
     * 줄바꿈을 한다.
     * <p>
     * - printWinner(): 최종 우승자를 출력한다. - [ ] 우승자가 2명 이상일 경우 `,`를 구분한다. - [ ] `"최종 우승자 : pobi, jun"` 형태로 출력한다.
     */

    @Test
    void printStartMessage() {
        RacingCarOutputView racingCarOutputView = new RacingCarOutputView();
        racingCarOutputView.printStartMessage();
        assertThat(OUTPUT.toString()).isEqualTo("실행 결과\n");
    }
}
