package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCarGame {
    private final Player player;

    public RacingCarGame(Player player) {
        this.player = player;
    }

    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            racingCars.add(new RacingCar(carNames.get(i)));
        }

        return racingCars;
    }

    public void roundStart(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.goOrStop();
        }
    }

    public void printRoundScore(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.printDistance();
        }
    }

    public List<RacingCar> chooseWinner(List<RacingCar> cars) {
        List<RacingCar> winners = new ArrayList<>();
        int max = getHighestDistance(cars);

        for (RacingCar car : cars) {
            if (car.distance == max) {
                winners.add(car);
            }
        }

        return winners;
    }

    public int getHighestDistance(List<RacingCar> cars) {
        cars.sort(new Comparator<RacingCar>() {
            @Override
            public int compare(RacingCar o1, RacingCar o2) {
                return o1.distance - o2.distance;
            }
        });

        return cars.get(cars.size() - 1).distance;
    }

    public void printWinnerName(List<RacingCar> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(",");
            }
        }
    }

    public void startGameRounds(List<RacingCar> cars, int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            roundStart(cars);
            printRoundScore(cars);
            System.out.println();
        }
    }

    public void init() {
        List<RacingCar> cars = createRacingCars(player.inputNames());
        int numberOfRounds = player.inputNumberOfRounds();
        System.out.println();
        System.out.println("실행 결과");
        startGameRounds(cars, numberOfRounds);
        printWinnerName(chooseWinner(cars));
    }
}
