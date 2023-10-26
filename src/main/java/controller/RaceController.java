package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import domain.Cars;
import view.InputView;

public class RaceController {
    private Cars cars;

    public RaceController() {

    }

    public void set() {
        cars = new Cars(InputView.carNames());
        printCarLists();
        start(InputView.attemptCount());
    }

    private void printCarLists() {
        cars.carsList.stream()
                .map(Car::getCarName)
                .forEach(System.out::println);
    }

    private void start(int attemptCount) {
        for (int i = attemptCount; i > 0; i--) {
            decideForwardMovement();
        }

        for (int i = 0; i < cars.carsList.size(); i++) {
            Car c = cars.carsList.get(i);
            System.out.println(c.getCarName() + " " + c.count.getCount());
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
