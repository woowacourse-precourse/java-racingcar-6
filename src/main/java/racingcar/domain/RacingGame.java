package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final Strategy randomStrategy = new RandomStrategy();

    public RacingGame(List<String> carNames) {
        this.cars = CarsFactory.createCars(carNames);
    }

    public void start(TryNumber tryNumber) {
        for (int i = 0; i < tryNumber.getTryNumber(); i++) {
            cars.race(randomStrategy);
            cars.getCars().stream().forEach(car -> {
                System.out.print(String.format("%s : ", car.getCarName()));
                printDistance(car.getDistance());
            });
            System.out.println();
        }
    }

    private static void printDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void finish() {
        List<String> winnersList = cars.findWinners();
        String winners = winnersList.stream().collect(Collectors.joining(", "));
        System.out.printf("최종 우승자 : %s", winners);
    }


}
