package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RaceRound;
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
        RaceRound raceRound = createGameRound();
        playAllGameRound(raceRound, cars);
        List<Car> winner = findWinner(cars);
        showWinner(winner);
    }

    private Cars createCars() {
        // 수정하기
//        List<String> names = inputView.inputNames();
//        Cars cars = new Cars(names);

        return cars;
    }

    private RaceRound createGameRound() {
        // 게임 라운드 회수 입력 받기
        Integer numberOfGameRound = inputView.inputCountOfGameRound();
        RaceRound raceRound = new RaceRound(numberOfGameRound, 0);

        return raceRound;
    }

    private void playAllGameRound(RaceRound raceRound, Cars cars) {
        // 각 라운드 별 게임 진행 및 결과 출력
        outputView.outputGameResultMessage();
        while (raceRound.isLeftRound()) {
            raceRound.increaseCurrentRound();
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
