package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCar;
import racingcar.utils.RacingCarGameInput;
import racingcar.utils.RacingCarGameOutput;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void validateCarNames_메소드를_사용시_자동차_이름이_5자가_넘어가는_경우_예외_발생() {
        List<RacingCar> carList = List.of(
            new RacingCar("exception")
        );
        assertThatThrownBy(() -> RacingCarGameInput.validateCarNames(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_BIGGER_THAN_5CHAR);
    }

    @Test
    void validateNumber_메소드를_사용시_숫자가_아닌_경우_예외_반환() {
        assertThatThrownBy(() -> RacingCarGameInput.validateNumber("12ad"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_NOT_NUMBER);
    }

    @Test
    void validateMoveCount_메소드를_사용시_1이상이_아닌_경우_예외_반환() {
        assertThatThrownBy(() -> RacingCarGameInput.validateMoveCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_NOT_POSITIVE);
    }

    @Test
    void printResultMessage_메소드를_사용시_실행_결과들이_출력(){
        List<RacingCar> carList = List.of(
            new RacingCar("pobi"),
            new RacingCar("woni")
        );
        carList.get(0).moveForword();
        RacingCarGameOutput.printResultMessage(carList);
        assertThat(output()).contains("pobi : -", "woni :");
    }

    @Test
    void printWinnerMessage_메소드를_사용시_1대의_우승한_자동차_출력(){
        List<RacingCar> carList = List.of(
            new RacingCar("woni")
        );
        RacingCarGameOutput.printWinnersMessage(carList);
        assertThat(output()).contains("최종 우승자는 : woni");
    }

    @Test
    void printWinnerMessage_메소드를_사용시_2대이상의_우승한_자동차들_출력(){
        List<RacingCar> carList = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("javaji")
        );
        RacingCarGameOutput.printWinnersMessage(carList);
        assertThat(output()).contains("최종 우승자는 : pobi, woni, javaji");
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
