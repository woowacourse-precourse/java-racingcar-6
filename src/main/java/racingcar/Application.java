package racingcar;

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
        List<String> carNames = inputCarNames();
        int tryCnt = inputTryCnt();

        racingGame = new RacingGame(carNames, tryCnt);

        view.println("실행 결과");
        while (!racingGame.isEndGame()){
            List<PerGameCarResultDto> resultDtos = racingGame.startRacingGame();
            view.printResult(resultDtos);
        }

        List<Car> racingWinner = racingGame.getRacingWinner();
        view.printWinner(racingWinner);

    }
    public static List<String> inputCarNames(){
        view.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return player.inputCarNames();
    }

    public static int inputTryCnt(){
        view.println("시도할 회수는 몇회인가요?");
        return player.inputTryCnt();
    }
}
