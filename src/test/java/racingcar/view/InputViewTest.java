package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarNameList;
import racingcar.domain.NumberOfGames;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfGamesInputValidator;

public class InputViewTest {
    @DisplayName("사용자에게 경주할 자동차 이름 입력 벋기 테스트")
    @Test
    void 사용자에게_경주할_자동차_이름_입력_받기_테스트() {
        // given
        InputView inputView = new InputView(new CarNamesInputValidator(), new NumberOfGamesInputValidator());
        String carNamesInput = "woowa,junju,baemi";
        InputStream in = new ByteArrayInputStream(carNamesInput.getBytes());
        System.setIn(in);

        // when, then
        assertThat(inputView.getCarNameListFromUser()).isInstanceOf(CarNameList.class);
    }

    @DisplayName("사용자에게 경주 게임 시도 횟수 입력 벋기 테스트")
    @Test
    void 사용자에게_경주_게임_시도_횟수_이름_입력_받기_테스트() {
        // given
        InputView inputView = new InputView(new CarNamesInputValidator(), new NumberOfGamesInputValidator());
        String numberOfGamesInput = "5";
        InputStream in = new ByteArrayInputStream(numberOfGamesInput.getBytes());
        System.setIn(in);

        // when, then
        assertThat(inputView.getNumberOfGamesFromUser()).isInstanceOf(NumberOfGames.class);
    }
}