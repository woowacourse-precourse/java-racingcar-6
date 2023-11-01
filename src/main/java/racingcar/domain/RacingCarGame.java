package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCarGame {
    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            racingCars.add(new RacingCar(carNames.get(i)));
        }

        return racingCars;
    }

    public void roundStart(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.makeRandomNumber();
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
        cars.sort(new Comparator<RacingCar>() {
            @Override
            public int compare(RacingCar o1, RacingCar o2) {
                return o1.distance - o2.distance;
            }
        });

        int max = cars.get(cars.size() - 1).distance;

        for (RacingCar car : cars) {
            if (car.distance == max) {
                winners.add(car);
            }
        }

        return winners;
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

    public void init() {
        Player player = new Player();
        List<RacingCar> cars = createRacingCars(player.inputNames());
        int numberOfRounds = player.inputNumberOfRounds();
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfRounds; i++) {
            roundStart(cars);
            printRoundScore(cars);
            System.out.println();
        }
        printWinnerName(chooseWinner(cars));
    }
}
