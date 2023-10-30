package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RaceRound;
import racingcar.domain.MovingStrategy;
import racingcar.util.RandomNumberUtil;
import racingcar.util.RandomNumberUtilImp;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MovingStrategy movingStrategy;


    public GameController(final InputView inputView , final OutputView outputView, final MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movingStrategy = movingStrategy;
    }


    public void play() {
        MovingStrategy movingStrategy = createMovingStrategy(new RandomNumberUtilImp());
        Cars cars = createCars(movingStrategy);
        RaceRound raceRound = createGameRound();
        playAllGameRound(raceRound, cars);
        List<Car> winner = findWinner(cars);
        showWinner(winner);
    }

    private MovingStrategy createMovingStrategy(final RandomNumberUtil randomNumberUtil) {
        return new MovingStrategy(randomNumberUtil);
    }

    private Cars createCars(final MovingStrategy movingStrategy) {
        List<Car> carList = convertNamesCarList(movingStrategy);
        return new Cars(carList);
    }

    private List<Car> convertNamesCarList(final MovingStrategy movingStrategy) {
        List<String> names = inputView.inputNames();
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(movingStrategy, name));
        }

        return carList;
    }

    private RaceRound createGameRound() {
        // 게임 라운드 회수 입력 받기
        Integer numberOfGameRound = inputView.inputCountOfGameRound();
        RaceRound raceRound = new RaceRound(numberOfGameRound, 0);

        return raceRound;
    }

    private void playAllGameRound(final RaceRound raceRound, final Cars cars) {
        // 각 라운드 별 게임 진행 및 결과 출력
        outputView.outputGameResultMessage();
        while (raceRound.isLeftRound()) {
            raceRound.increaseCurrentRound();
            cars.raceAllCars();
            outputView.outputCarsPosition(cars.getCars());
        }
    }

    private List<Car> findWinner(final Cars cars) {
        Integer winnerPosition = cars.findWinnerPosition();
        List<Car> winner = cars.findWinner(winnerPosition);

        return winner;
    }

    private void showWinner(final List<Car> winner) {
        outputView.outputWinner(winner);
    }

}
