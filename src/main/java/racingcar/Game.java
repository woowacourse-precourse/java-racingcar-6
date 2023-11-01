package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Game {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String GAME_WINNER_MESSAGE = "최종 우승자 : ";

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

    public void run() {
        for (Car car : cars) {
            car.moveForward();
            car.printMovedResult();
        }
        System.out.println();
    }
    public void setRacingCarList() {
        user.setCarName()
                .forEach(carName -> cars.add(new Car(carName)));
    }

    public void setAttemptCounts() {
        trialCounts = user.setTrialNumber();
    }

    public List<String> decideWinners() {
        cars.sort(Comparator.comparing(Car::getPosition).reversed());
        final int winnerPosition = cars.get(0).getPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void printWinners() {
        System.out.println(GAME_WINNER_MESSAGE + String.join(", ", decideWinners()));
    }
}

