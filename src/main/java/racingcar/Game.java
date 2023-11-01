package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<String> carNames;
    int round;

    public Game() {
        carNames = Input.inputCarNames();
        round = Input.inputRound();
    }

    public void run() {
        List<Car> carEntry = setCars();
        System.out.println("실행 결과");
        raceStart(carEntry);
        checkWinners(carEntry);

    }

    private List<Car> setCars() {
        List<Car> carEntry = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            carEntry.add(new Car(carNames.get(i)));
        }
        return carEntry;
    }

    private void raceStart(List<Car> carEntry) {
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < carEntry.size(); j++) {
                carEntry.get(j).onceRoundStart();
                carEntry.get(j).printCarState();
            }
            System.out.println();
        }
    }

    private void checkWinners(List<Car> carEntry) {
        List<Integer> distances = new ArrayList<>();
        int winnerDistance = 0;
        for (int i = 0; i < carEntry.size(); i++) {
            int carDistance = carEntry.get(i).finalDistance();
            distances.add(carDistance);
            if (carDistance > winnerDistance) {
                winnerDistance = carDistance;
            }
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < distances.size(); i++) {
            if (distances.get(i) == winnerDistance) {
                winners.add(carNames.get(i));
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }

    }
}
