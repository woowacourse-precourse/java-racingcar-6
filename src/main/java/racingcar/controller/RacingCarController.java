package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.validation.InputValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame() {
        List<String> carNamesInput = getCarNamesInput();
        Integer triesInput = getTriesInput();
        Cars cars = initCar(carNamesInput);
        outputView.printOneCycleResultMessage();
        for (int i = 0; i < triesInput; i++) {
            playGame(cars);
        }

    }

    private Integer getTriesInput() {
        String input = inputView.readTriesInput();
        InputValidation.validateTriesInput(input);
        return Integer.parseInt(input);
    }

    private List<String> getCarNamesInput() {
        String input = inputView.readCarNamesInput();
        String[] splitInputNames = input.split(",");
        List<String> inputNames = Arrays.asList(splitInputNames);
        InputValidation.validateCarNamesInput(inputNames);
        return inputNames;
    }

    private Cars initCar(List<String> carNames) {
        Cars cars = new Cars();
        for (String name : carNames) {
            cars.addCar(new Car(name, 0));
        }
        return cars;
    }

    private int carsSize(Cars cars) {
        return cars.getCars().size();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void calculateGoForward(Car car, int randomNumber) {
        if (randomNumber > 3) {
            car.goForward();
        }
    }

    private void playGame(Cars cars) {
        for (Car car : cars.getCars()) {
            int randomNumber = getRandomNumber();
            calculateGoForward(car, randomNumber);
            outputView.printCurrentLocation(car);
        }
        outputView.printNextLine();
    }

}