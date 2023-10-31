package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final int MINIMUM_VALUE_TO_MOVE = 4;
    public static final int INIT_MAX_SCORE = -1;
    public static final int END_OF_GAME = 0;
    public static final String RESULT_OF_GAME_MESSAGE = "\n실행 결과";
    private List<Car> cars = new ArrayList<>();
    private int count;

    public void run() {
        gameLogic();
    }

    private boolean isMoveForward() {
        return CreateRandomNumber.getNumber() >= MINIMUM_VALUE_TO_MOVE;
    }

    private void setCars(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private List<Car> judge(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        int maxScore = INIT_MAX_SCORE;

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
        System.out.println(RESULT_OF_GAME_MESSAGE);
        while (count > END_OF_GAME) {
            moveCar();
            Output.viewResultOfRound(cars);
            count--;
        }
        Output.viewResultOfGame(judge(cars));
    }
}
