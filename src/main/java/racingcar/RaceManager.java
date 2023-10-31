package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {
    private final RaceOfficial raceOfficial = new RaceOfficial();

    private List<Car> cars = new ArrayList<>();
    private int tryNumber;

    public void run() {
        init();
        start();

        List<Car> winners = raceOfficial.findWinners(cars);
        showWinners(winners);
    }

    public void init() {
        Util.print(MessageType.INPUT_TRY_NUMBER);
        String[] carNameSplit = inputCarNames().split(",");
        for (String name : carNameSplit) {
            cars.add(new Car(name));
        }

        Util.print(MessageType.INPUT_TRY_NUMBER);
        tryNumber = inputTryNumber();
    }

    public String inputCarNames() {
        return Console.readLine();
    }

    public int inputTryNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public void start() {
        Util.print(MessageType.SHOW_RUN_RESULT);
        for (int i = 0; i < tryNumber; i++) {
            cars.stream().forEach(car -> {
                car.tryToMove();
                System.out.println(car);
            });
            System.out.println();
        }
    }

    public void showWinners(List<Car> winners) {
        List<String> names = winners.stream().map(Car::getName).collect(Collectors.toList());
        String allWinners = String.join(", ", names);

        Util.print(MessageType.SHOW_WINNERS, allWinners);
    }
}
