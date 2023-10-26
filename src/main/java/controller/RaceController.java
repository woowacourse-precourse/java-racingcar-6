package controller;

import static constant.ConstantString.EXECUTION_RESULT;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

public class RaceController {
    private Cars cars;

    public RaceController() {

    }

    public void set() {
        cars = new Cars(InputView.carNames());
        // printCarLists();
        start(InputView.attemptCount());
    }

    private void printCarLists() {
        cars.carsList.stream()
                .map(Car::getCarName)
                .forEach(System.out::println);
    }

    private void start(int attemptCount) {
        System.out.println(EXECUTION_RESULT);
        for (int i = attemptCount; i > 0; i--) {
            decideForwardMovement();
            OutputView.printProcess(cars.getCarsList());
        }
    }

    private void decideForwardMovement() {
        for (int i = 0; i < cars.carsList.size(); i++) {
            cars.carsList.get(i).moveOrStop(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
