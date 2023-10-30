package racingcar.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class ConsoleTest {

    @Test
    void 콘솔_출력_메세지() {
        assertAll(
                () -> assertThat(Console.INIT.message()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
                () -> assertThat(Console.TRY.message()).isEqualTo("시도할 회수는 몇회인가요?"),
                () -> assertThat(Console.RESULT.message()).isEqualTo("실행 결과"),
                () -> assertThat(Console.WINNER.message()).isEqualTo("최종 우승자 : "),
                () -> assertThat(Console.SEPARATOR.message()).isEqualTo(" : "),
                () -> assertThat(Console.PROGRESS.message()).isEqualTo("-")
        );
    }
}
