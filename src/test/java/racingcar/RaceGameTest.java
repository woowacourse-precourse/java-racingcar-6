package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.controller.CarNameValidator;
import racingcar.controller.CarRacingController;
import racingcar.controller.GameController;
import racingcar.controller.RandomUtility;
import racingcar.model.RaceGame;

public class RaceGameTest {
    private static final int RACECAR_ADVENCE_NUMBER = 4;

    RaceGame raceGame = new RaceGame();
    GameController gameController = new GameController();
    CarRacingController carRacingController = new CarRacingController();
    CarNameValidator carNameValidator = new CarNameValidator();
    RandomUtility randomUtility = new RandomUtility();

    @Test
    void 공백_제거하여_자동차_입력_이름_저장하는지_확인() {

        String inputCarName = "pobi. woni,jun  ";
        raceGame.setInputCarName(inputCarName);

        String result = raceGame.getInputCarName();
        String expect = "pobi.woni,jun";

        assertEquals(result, expect);
    }

    @Test
    void 쉼표_기준으로_자동차_이름_분류하는지_확인() {

        String InputCarName = "pobi.,woni, jun*,nila, lala";
        raceGame.setInputCarName(InputCarName);

        gameController.saveCarNames(raceGame);
        List<String> resultCarName = raceGame.getCarNames();

        assertThat(resultCarName).contains("pobi.", "woni", "jun*", "nila", "lala");
    }

    @Test
    void 경주할_자동차_2대_이상인지_확인() {

        List<String> inputCarName = new ArrayList<>(Arrays.asList("pobi"));

        assertThatThrownBy(() -> carNameValidator.toValidateCarName(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("2대 이상의 자동차 이름을 입력해주세요.");
    }

    @Test
    void 입력한_차_이름이_공백인지_확인() {

        List<String> inputCarName = new ArrayList<>(Arrays.asList("", "pobi", "jun"));

        assertThatThrownBy(() -> carNameValidator.toValidateCarName(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 아닌 자동차 이름을 입력해주세요.");
    }

    @Test
    void 자동차_이름아_5이하인지_확인() {

        List<String> inputCarName = new ArrayList<>(Arrays.asList("carName", "jun"));

        assertThatThrownBy(() -> carNameValidator.toValidateCarName(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5 이하의 자동차 이름을 입력해주세요.");
    }

    @Test
    void 서로_다른_자동차_이름인지_확인() {

        List<String> inputCarName = new ArrayList<>(Arrays.asList("pobi", "pibi", "pobi"));

        assertThatThrownBy(() -> carNameValidator.toValidateCarName(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 자동차 이름을 입력해주세요.");
    }

    @Test
    void 전진_멈춤인지_확인() {
        int randomNubmer = randomUtility.generateRandomNumber();

        assertThat(randomNubmer >= RACECAR_ADVENCE_NUMBER);
    }

    @Test
    void 자동차_별_전진_횟수_저장하는_모델_초기화_확인() {

        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        raceGame.setCarNames(carNames);

        carRacingController.playGame(raceGame);
        List<String> result = raceGame.getCarMoveCounts();
        List<String> expect = Arrays.asList("", "", "");

        assertEquals(result, expect);
    }

}
