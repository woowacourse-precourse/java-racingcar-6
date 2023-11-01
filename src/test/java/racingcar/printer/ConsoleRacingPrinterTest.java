package racingcar.printer;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.car.RacingCar;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleRacingPrinterTest extends NsTest {

    @Test
    void requestInputRacingCarName() {
        RacingPrinter racingPrinter = new ConsoleRacingPrinter();

        racingPrinter.requestInputRacingCarName();

        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void requestInputTryCount() {
        RacingPrinter racingPrinter = new ConsoleRacingPrinter();

        racingPrinter.requestInputTryCount();

        assertThat(output()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    void noticeResult() {
        RacingPrinter racingPrinter = new ConsoleRacingPrinter();

        racingPrinter.noticeResult();

        assertThat(output()).contains("실행결과");
    }

    @Test
    void printResultDetail() {
        RacingPrinter racingPrinter = new ConsoleRacingPrinter();
        RacingCar racingCar = new RacingCar("Cha");

        racingPrinter.printResultDetail(racingCar);

        assertThat(output()).contains("Cha :");
    }

    @Test
    void printLine() {
        RacingPrinter racingPrinter = new ConsoleRacingPrinter();

        racingPrinter.printLine();

        assertThat(output()).contains("");
    }

    @Test
    void noticeWinner() {
        RacingPrinter racingPrinter = new ConsoleRacingPrinter();
        List<String> winners = Arrays.stream(new String[]{"one", "two"}).toList();

        racingPrinter.noticeWinner(winners);

        assertThat(output()).contains("최종 우승자 : one, two");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}