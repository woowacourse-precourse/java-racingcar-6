package racingcar;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingCarDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.inputCars();
        List<String> racingCarNames = InputView.racingCars();
        OutputView.inputTurn();
        int gameTurn = InputView.gameTurn();

        RacingGame racingGame = new RacingGame(racingCarNames);

        OutputView.progressGameIntro();

        for(int i = 0; i < gameTurn; i++){
            List<RacingCarDto> racingCarDtoList = racingGame.progress();
            OutputView.gameProgress(racingCarDtoList);
        }

        OutputView.gameResult(racingGame.result());
    }
}
