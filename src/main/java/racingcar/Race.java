package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int time;

    public Race() {
        String[] names = Screen.askCarNames();
        time = Screen.askRacingTime();
        cars = new ArrayList<>();

        for (String name : names)
            cars.add(new Car(name));
    }

    public Race(List<Car> cars, int time) {
        this.cars = cars;
        this.time = time;
    }
    public void run() {
        System.out.println("\n실행 결과");
        for (int idx = 0; idx < time; idx++) {
            playOneRound();
            Screen.displayResult(cars);
        }
    }

    private void playOneRound() {
        for (Car car : cars) {
            car.moveFoward();
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maximumMove = 0;

        for (Car car : cars) {
            if (car.getNumberOfMove() > maximumMove) {
                winners.clear();
            }
            if (car.getNumberOfMove() >= maximumMove) {
                maximumMove = car.getNumberOfMove();
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
