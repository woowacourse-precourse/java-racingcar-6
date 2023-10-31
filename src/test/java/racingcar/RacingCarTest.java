package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.controller.GameController;
import racingcar.model.RaceCar;
import racingcar.service.GameService;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class RacingCarTest extends NsTest {
    private static final int MOVE_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("run_자동차_객체_생성_테스트")
    @Test
    void run_자동차_객체_생성_테스트() {
        List<String> names = Arrays.asList("pobi,songe,rose".split(",", -1));
        List<RaceCar> raceCars = new ArrayList<>();
        GameService gameService = new GameService();

        raceCars = gameService.createRaceCarObject(raceCars, names);

        assertThat(raceCars).extracting("name")
                .contains("pobi", "songe", "rose");
    }

    @DisplayName("run_자동차_전진_확인")
    @Test
    void run_자동차_전진_확인() {
        List<String> names = Arrays.asList("pobi,songe,rose".split(",", -1));
        List<RaceCar> raceCars = new ArrayList<>();
        GameService gameService = new GameService();
        int tryNumer = 2;

        raceCars = gameService.createRaceCarObject(raceCars, names);

        while (tryNumer > 0) {
            gameService.MoveForward(raceCars.get(0), STOP);
            gameService.MoveForward(raceCars.get(1), MOVE_FORWARD);
            gameService.MoveForward(raceCars.get(2), STOP);

            tryNumer--;
        }
        final List<RaceCar> resultRaceCars = raceCars;
        assertAll(
                () -> assertThat(resultRaceCars).extracting("name")
                        .contains("pobi", "songe", "rose"),
                () -> assertThat(resultRaceCars).extracting("moveForwardCount")
                        .contains(0, 2, 0)
        );
    }

    @DisplayName("run_최종_우승자_두명_이상일_경우_출력")
    @Test
    void run_최종_우승자_두명_이상일_경우_출력() {
        List<String> names = Arrays.asList("pobi,songe,rose".split(",", -1));
        List<RaceCar> raceCars = new ArrayList<>();
        GameService gameService = new GameService();
        OutputView outputView = new OutputView();
        int tryNumer = 2;

        raceCars = gameService.createRaceCarObject(raceCars, names);

        while (tryNumer > 0) {
            gameService.MoveForward(raceCars.get(0), MOVE_FORWARD);
            gameService.MoveForward(raceCars.get(1), MOVE_FORWARD);
            gameService.MoveForward(raceCars.get(2), STOP);

            tryNumer--;
        }

        List<String> winner = gameService.gameWinner(raceCars);
        outputView.printWinner(winner);

        assertThat(output())
                .isEqualTo("최종 우승자 : pobi, songe");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}