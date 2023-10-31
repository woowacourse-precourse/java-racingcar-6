package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.data.CarRepository;
import racingcar.util.CarUtil;
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
        CarUtil.printWinner(carRepository.getWinnerNames());
    }

    private void getCarList() {
        CarUtil.printGetCarList();
        String[] carNames = Console.readLine().split(CarUtil.CAR_NAME_SPLIT);
        CarInputValidator.checkCarNameDuplicate(carNames);
        carRepository.setCarList(carNames);
    }

    private void getRound() {
        CarUtil.printGetRound();
        String roundString = Console.readLine();
        RoundInputValidator.checkRoundNumberFormat(roundString);
        carRepository.setRound(Integer.parseInt(roundString));
    }

    private void playRound() {
        CarUtil.printResult();
        carRepository.playRound();
    }
}
