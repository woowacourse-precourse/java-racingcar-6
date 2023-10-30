package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameManager {
    static List<Car> carRace;
    static List<String> winner;

    public GameManager() {
        InputValue inputValue = new InputValue();
        playGame();
    }

    private void playGame() {
        makeCars(InputValue.carName);

        for (int i = 0; i < InputValue.count; i++) {
            checkForwardStop(carRace);
            ResultPrinter.printCourse(carRace);
        }
    }

    private void makeCars(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            Car car = new Car(list.get(i));
            carRace.add(car);
        }
    }

    private void checkForwardStop(List<Car> car) {
        for (int i = 0; i < car.size(); i++) {
            int randomNum = getRandomNum();

            decideCallForwardStop(car.get(i), randomNum);
        }
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(0,9);
    }

    private void decideCallForwardStop(Car car, int RandomNum) {
        if (RandomNum >= 4) {
            car.forward();
        } else {
            car.stop();
        }
    }
}
