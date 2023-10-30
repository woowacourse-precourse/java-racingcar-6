package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameRound;
import racingcar.domain.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    private final MovingStrategy movingStrategy;


    public GameController(InputView inputView , OutputView outputView, MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movingStrategy = movingStrategy;
    }


    public void play() {
        Cars cars = createCars();
        GameRound gameRound = createGameRound();
        playAllGameRound(gameRound, cars);
        List<Car> winner = findWinner(cars);
        showWinner(winner);
    }

    private Cars createCars() {
        // 경주 할 자동차 이름 입력 받기
        List<String> names = inputView.inputNames();
        Cars cars = new Cars(names, movingStrategy);

        return cars;
    }

    private GameRound createGameRound() {
        // 게임 라운드 회수 입력 받기
        Integer numberOfGameRound = inputView.inputCountOfGameRound();
        GameRound gameRound = new GameRound(numberOfGameRound, 0);

        return gameRound;
    }

    private void playAllGameRound(GameRound gameRound, Cars cars) {
        // 각 라운드 별 게임 진행 및 결과 출력
        outputView.outputGameResultMessage();
        while (gameRound.isLeftRound()) {
            gameRound.increaseCurrentRound();
            cars.raceAllCars();
            outputView.outputCarsPosition(cars.getCars());
        }
    }

    private List<Car> findWinner(Cars cars) {
        Integer winnerPosition = cars.findWinnerPosition();
        List<Car> winner = cars.findWinner(winnerPosition);

        return winner;
    }

    private void showWinner(List<Car> winner) {
        outputView.outputWinner(winner);
    }

}
