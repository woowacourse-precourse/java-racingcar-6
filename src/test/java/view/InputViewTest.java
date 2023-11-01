package view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Players;
import racingcar.service.RaceService;
import racingcar.view.InputView;

class InputViewTest extends NsTest {

    private static RaceService raceService = new RaceService();
    private static InputView inputView = new InputView();

    @DisplayName("이름이 6자리 이상일 때")
    @Test
    void validateNameSixWords() {
        List<String> players = List.of("robin","kelvin");

        raceService.raceOneSimulate(new Players(players));

    }

    @DisplayName("아예 숫자가 아닐 때")
    @Test
    void validateIsNumber() {

        inputView.checkAttemptCount("a");

        assertThatThrownBy(() -> {
            inputView.checkAttemptCount("a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 숫자입니다.");

    }

    @DisplayName("중간에 숫자가 아닌 문자가 들어갈 때")
    @Test
    void validateMiddleIsNotNumber() {

        assertThatThrownBy(() -> {
            inputView.checkAttemptCount("1a3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 숫자입니다.");

    }


    @Override
    protected void runMain() {

    }
}
