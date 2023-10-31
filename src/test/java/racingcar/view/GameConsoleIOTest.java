package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.CustomAssertions;
import racingcar.util.IOTest;
import racingcar.view.GameConsoleIO;


class GameConsoleIOTest extends IOTest {

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

    @Test
    void 자동차_입력() {
        String inputStr = "car1,car2,car3";
        List<String> inputList = Arrays.stream(inputStr.split(",")).toList();

        input(inputStr);
        List<String> carNames = gameConsoleIO.getCarNames();

        assertThat(carNames.containsAll(inputList))
                .isTrue();

    }

    @Test
    void 자동차_입력_예외_공백_type1() {
        assertThatThrownBy(
                () -> {
                    input("\n");
                    gameConsoleIO.getCarNames();
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input invalid : input value is blank");
    }

    @Test
    void 자동차_입력_예외_공백_type2() {
        assertThatThrownBy(
                () -> {
                    input(" ");
                    gameConsoleIO.getCarNames();
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input invalid : input value is blank");
    }

    @Test
    void 자동차_입력_예외_이름수_제한() {
        assertThatThrownBy(
                () -> {
                    input("123456");
                    gameConsoleIO.getCarNames();
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input invalid : size of input value exceeds 5");
    }

    @Test
    void 이동차수_입력() {
        int inputValue = 5;
        input(String.valueOf(inputValue));
        int movingCount = gameConsoleIO.getMovingCount();

        assertThat(movingCount)
                .isEqualTo(inputValue);
    }

    @Test
    void 이동차수_입력_예외_공백_type1() {
        assertThatThrownBy(
                () -> {
                    input("\n");
                    gameConsoleIO.getMovingCount();
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input invalid : input value is blank");

    }

    @Test
    void 이동차수_입력_예외_공백_type2() {
        assertThatThrownBy(
                () -> {
                    input(" ");
                    gameConsoleIO.getMovingCount();
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input invalid : input value is blank");

    }

    @Test
    void 이동차수_입력_예외_not_numeric() {
        assertThatThrownBy(
                () -> {
                    input("!");
                    gameConsoleIO.getMovingCount();
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid input String:");

    }

}
