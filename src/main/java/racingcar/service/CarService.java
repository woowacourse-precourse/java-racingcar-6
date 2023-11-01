package racingcar.service;

import racingcar.data.CarRepository;
import racingcar.io.CarInput;
import racingcar.io.CarOutput;

public class CarService {
    private final CarRepository carRepository;
    private int round;

    public CarService() {
        carRepository = new CarRepository();
    }

    public void start() {
        getCarList();
        getRound();
        playRound();
        findWinners();
    }

    private void getCarList() {
        CarOutput.printGetCarList();
        carRepository.setCarList(CarInput.getCarNames());
    }

    private void getRound() {
        CarOutput.printGetRound();
        round = CarInput.getRound();
    }

    private void playRound() {
        CarOutput.printResult();
        for (int i = 0; i < round; i++) {
            carRepository.playRound();
            CarOutput.printNewLine();
        }
    }

    private void findWinners() {
        CarOutput.printWinner(carRepository.findWinners());
    }
}
