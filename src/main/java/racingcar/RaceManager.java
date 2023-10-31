package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        setCars();
        setTryNumber();
    }

    public void setCars() {
        Util.print(MessageType.INPUT_TRY_NUMBER);
        Arrays.stream(inputCarNames().split(","))
                .forEach(name -> cars.add(new Car(name)));
    }

    public void setTryNumber() {
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
        Stream.iterate(0, i -> i + 1).limit(tryNumber)
            .forEach(moment -> racing());
    }

    public void racing() {
        cars.forEach(car -> {
            car.tryToMove();
            car.print();
        });
        System.out.println();
    }

    public void showWinners(List<Car> winners) {
        List<String> names = winners.stream().map(Car::getName).collect(Collectors.toList());
        String allWinners = String.join(", ", names);

        Util.print(MessageType.SHOW_WINNERS, allWinners);
    }
}
