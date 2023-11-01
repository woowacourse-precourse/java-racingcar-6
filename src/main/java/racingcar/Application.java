package racingcar;

import static racingcar.constant.OutputMessage.INPUT_CAR_NAMES;
import static racingcar.constant.OutputMessage.INPUT_TRY_COUNT;
import static racingcar.constant.OutputMessage.RUN_RESULT;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Player;
import racingcar.domain.RacingGame;
import racingcar.dto.PerGameCarResultDto;

public class Application {
    static RacingGame racingGame;
    static Player player = new Player();
    static final View view = new View();

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        racingGame = new RacingGame(inputCarNames(), inputTryCnt());

        view.println(RUN_RESULT);
        while (!racingGame.isEndGame()){
            List<PerGameCarResultDto> resultDtos = racingGame.startRacingGame();
            view.printResult(resultDtos);
        }

        List<Car> racingWinner = racingGame.getRacingWinner();
        view.printWinner(racingWinner);

    }
    public static List<String> inputCarNames(){
        view.println(INPUT_CAR_NAMES);
        return player.inputCarNames();
    }

    public static int inputTryCnt(){
        view.println(INPUT_TRY_COUNT);
        return player.inputTryCnt();
    }
}
