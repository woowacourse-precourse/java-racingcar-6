package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int count;

    public void run() {
        gameLogic();
    }

    private boolean isMoveForward() {
        return CreateRandomNumber.getNumber() >= 4;
    }

    private void setCars(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private List<Car> judge(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        int maxScore = -1;

        for (Car car : cars) {
            if (car.getState() == maxScore) {
                winner.add(car);
            }

            if (car.getState() > maxScore) {
                winner.clear();
                maxScore = car.getState();
                winner.add(car);
            }
        }
        return winner;
    }

    private void moveCar() {
        for (Car car : cars) {
            if (isMoveForward()) {
                car.move();
            }
        }
    }

    private void gameLogic() {
        setCars(UserInput.inputNames());
        count = UserInput.inputNumberOfGames();
        System.out.println("\n실행 결과");
        while (count > 0) {
            moveCar();
            Output.viewResultOfRound(cars);
            count--;
        }
        Output.viewResultOfGame(judge(cars));
    }
}
