package racingcar;

import java.util.ArrayList;
import java.util.List;


public class Game {

    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    private final User user;
    private final List<Car> cars;

    private int trialCounts;

    public Game() {
        user = new User();
        cars = new ArrayList<>();
        trialCounts = 0;
    }


    public void play() {
        setRacingCarList();
        setAttemptCounts();
        System.out.println();
        System.out.println(GAME_RESULT_MESSAGE);
        for (int i = 0; i < trialCounts; i++) {
            run();
        }
    }

    public void setRacingCarList() {
        user.setCarName()
                .forEach(carName -> cars.add(new Car(carName)));
    }

    public void setAttemptCounts() {
        trialCounts = user.setTrialNumber();
    }

    public void run() {
        for (Car car : cars) {
            car.moveForward();
            car.printMovedResult();
        }
        System.out.println();
    }

}

