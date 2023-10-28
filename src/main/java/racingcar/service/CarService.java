package racingcar.service;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.validator.InputValidator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class CarService {
    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();
    CarRepository carRepository = new CarRepository();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public int getCarNameAndTryCount() {
        getCarNameAndCheckValidation();
        return getTryCountAndCheckValidation();
    }

    private void getCarNameAndCheckValidation() {
        List<String> carNameList = splitCarNames(inputView.getCarNames());
        inputValidator.checkCarNameInputValidation(carNameList);
        saveCarNameList(carNameList);
    }

    private void saveCarNameList(List<String> carNameList) {
        for (String carName : carNameList) {
            carRepository.save(carName);
        }
    }

    private int getTryCountAndCheckValidation() {
        return inputValidator.checkTryCountInputValidation(inputView.getTryCount());
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public List<Car> game() {
        for (int i = 0; i < carRepository.carList.size(); i++) {
            if (randomNumberGenerator.pickRandomNumber() >= 4) {
                carRepository.moveForward(carRepository.carList.get(i));
            }
        }
        return carRepository.carList;
    }
}
