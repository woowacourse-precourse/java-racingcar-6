package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.ConsolePrintTest;
import racingcar.util.CustomAssertions;
import racingcar.view.GameConsoleIO;


class GameConsoleIOTest extends ConsolePrintTest {

    GameConsoleIO gameConsoleIO;

    @BeforeEach
    void beforeEach() {
        gameConsoleIO = new GameConsoleIO();
    }


    @Test
    void 실행_결과_메시지_출력() {
        CustomAssertions.assertSimpleTest(
                () -> {
                    gameConsoleIO.printExecuteResultMessage();
                    assertThat(output(false, true))
                            .isEqualTo("""
                                                                
                                    실행 결과""");
                }
        );
    }


    @Test
    void 자동차_위치_출력문_확인() {
        CustomAssertions.assertSimpleTest(
                () -> {
                    gameConsoleIO.printCarLocationByCarName("car1", 1);
                    gameConsoleIO.printCarLocationByCarName("car0", 0);
                    assertThat(output(true, false))
                            .contains("car0 : ", "car1 : -");
                }
        );

    }

    @Test
    void 우승자_출력() {
        List<String> winnerList = new ArrayList<>();

        CustomAssertions.assertSimpleTest(
                () -> {
                    winnerList.add("car1");
                    gameConsoleIO.printWinners(winnerList);

                    winnerList.add("car2");
                    gameConsoleIO.printWinners(winnerList);

                    assertThat(output())
                            .contains("최종 우승자 : car1", "최종 우승자 : car1, car2");
                }
        );

    }


}
