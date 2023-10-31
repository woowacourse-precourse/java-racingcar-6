package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceController {
    private final RaceOfficial official = new RaceOfficial();

    private List<Car> cars = new ArrayList<>();
    private int tryNumber;

    public void run() {
        initCars();
        initTryNumber();
        startRace();

        int longestDistance = official.findLongestDistance(cars);
        List<Car> winners = official.findWinners(cars, longestDistance);
        reportWinners(winners);
    }

    public void initCars() {
        Util.print(MessageType.INPUT_CAR_NAMES);
        String input = Util.getUserInput();
        Util.handleCarNamesException(input);

        Util.splitNamesAsStream(input, Constant.NAME_DELIMITER)
            .forEach(name -> cars.add(new Car(name)));
    }

    public void initTryNumber() {
        Util.print(MessageType.INPUT_TRY_NUMBER);
        String input = Util.getUserInput();
        Util.handleTryNumberException(input);

        tryNumber = Integer.parseInt(input);
    }

    public void startRace() {
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

    public void reportWinners(List<Car> winners) {
        List<String> names = winners.stream().map(Car::getName).collect(Collectors.toList());
        String allWinners = String.join(", ", names);

        Util.print(MessageType.SHOW_WINNERS, allWinners);
    }
}
