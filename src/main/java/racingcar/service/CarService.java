package racingcar.service;

import racingcar.data.CarRepository;
import racingcar.io.CarInput;
import racingcar.io.CarOutput;

public class CarService {
    private final CarRepository carRepository;

    public CarService() {
        carRepository = new CarRepository();
    }

    public void start() {
        getCarList();
        getRound();
        playRound();
        findWinner();
    }

    private void getCarList() {
        CarOutput.printGetCarList();
        carRepository.setCarList(CarInput.getCarNames());
    }

    private void getRound() {
        CarOutput.printGetRound();
        carRepository.setRound(CarInput.getRound());
    }

    private void playRound() {
        CarOutput.printResult();
        carRepository.playRound();
    }

    private void findWinner() {
        carRepository.findWinners();
    }
}
