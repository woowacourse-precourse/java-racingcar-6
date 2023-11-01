package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    public static int LOWER_BOUND_OF_NUMBER = 0;
    public static int UPPER_BOUND_OF_NUMBER = 9;

    private List<RacingCar> cars;

    public RacingCars(List<String> carNames) {
        this.cars = new ArrayList<>();

        carNames.stream()
                .forEach(name -> this.cars.add(new RacingCar(name)));
    }

    public void attemptMove(int numberOfAttempts) {
        while (numberOfAttempts-- > 0) {
            attemptMoveEachCar();
            printCurrentDistanceEachCar();
            System.out.println();
        }
    }


    private void attemptMoveEachCar() {
        this.cars.stream()
                .forEach(racingCar -> {
                    int randomNumber = Randoms.pickNumberInRange(LOWER_BOUND_OF_NUMBER, UPPER_BOUND_OF_NUMBER);
                    racingCar.move(randomNumber);
                });
    }

    private void printCurrentDistanceEachCar() {
        this.cars.stream()
                .forEach(racingCar -> {
                    String graph = racingCar.getDistanceGraph();
                    System.out.println(graph);
                });
    }

    public void printWinners() {
        int maxDistance = getMaxDistance();
        List<String> winners = getWinners(maxDistance);
        printWinnersName(winners);
    }


    private List<String> getWinners(int maxDistance) {
        return cars.stream()
                .filter(racingCar -> racingCar.getDistance() == maxDistance)
                .map(racingCar -> racingCar.getName())
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(RacingCar::getDistance)
                .max()
                .orElse(0);
    }

    private static void printWinnersName(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
