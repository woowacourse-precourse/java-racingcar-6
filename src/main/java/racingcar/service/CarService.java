package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.data.CarRepository;
import racingcar.io.CarOutput;
import racingcar.utils.CarUtil;
import racingcar.validator.CarInputValidator;
import racingcar.validator.RoundInputValidator;

public class CarService {
    private final CarRepository carRepository;

    public CarService() {
        carRepository = new CarRepository();
    }

    public void start() {
        getCarList();
        getRound();
        playRound();
        CarOutput.printWinner(carRepository.getWinnerNames());
    }

    private void getCarList() {
        CarOutput.printGetCarList();
        String[] carNames = Console.readLine().split(CarUtil.CAR_NAME_SPLIT);
        CarInputValidator.checkCarNameDuplicate(carNames);
        carRepository.setCarList(carNames);
    }

    private void getRound() {
        CarOutput.printGetRound();
        String roundString = Console.readLine();
        RoundInputValidator.checkRoundNumberFormat(roundString);
        carRepository.setRound(Integer.parseInt(roundString));
    }

    private void playRound() {
        CarOutput.printResult();
        carRepository.playRound();
    }
}
