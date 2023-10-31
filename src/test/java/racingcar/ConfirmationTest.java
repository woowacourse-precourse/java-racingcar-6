package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.handler.UserInputHandler;

import java.util.Arrays;
import java.util.List;

public class ConfirmationTest extends NsTest {
    UserInputHandler userInputHandler = new UserInputHandler();
    GameController gameController = new GameController();

    @Test
    void 자동차이름_5자초과_예외_처리() {
        String nameList = "iamdabin";

        assertThatThrownBy(() -> userInputHandler.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차이름_중복_예외_처리() {
        List<String> nameList = Arrays.asList("dabin","dabin");

        assertThatThrownBy(() -> userInputHandler.checkDuplicateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 자동차이름_공백_예외_처리() {
        String nameList = "";

        assertThatThrownBy(() -> userInputHandler.validateUserInput(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해주세요.");
    }

    @Test
    void 시도횟수_예외_처리() {
        String count = "";
        String numCount = "0";
        String numFormatCount = "dabin";
        int attemptCount = Integer.parseInt(numCount);

        assertThatThrownBy(() -> userInputHandler.validateAttemptCount(String.valueOf(attemptCount)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 0보다 커야 합니다.");

        assertThatThrownBy(() -> userInputHandler.validateAttemptCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수를 입력해주세요.");

        assertThatThrownBy(() -> userInputHandler.validateAttemptCount(numFormatCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자만 입력할 수 있습니다.");
    }

    @Test
    void setUp_자동차_객체_생성_테스트() {
        gameController.setUp("pobi,dabin,jun");
        gameController.run(1);

        List<String> winners = gameController.getWinners();
        assertThat(winners).isNotEmpty();
    }

    @Test
    public void getWinners_우승자_자동차_이름_반환_테스트() {
        gameController.setUp("pobi,dabin,jun");
        gameController.run(1);

        List<String> winners = gameController.getWinners();
        assertThat(winners).isNotEmpty();
        assertThat(winners.size()).isLessThanOrEqualTo(3);
        assertThat(winners).allMatch(name -> name.equals("pobi") || name.equals("dabin") || name.equals("jun"));
    }

    @Override
    protected void runMain() { Application.main(new String[]{});}
}

