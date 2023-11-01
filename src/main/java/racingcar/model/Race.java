package racingcar.model;

import racingcar.view.GameView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Race {
    private final List<Car> carList;
    private final int rounds;
    private final GameView gameView;

    public Race(List<Car> carList, int rounds) {
        this.carList = carList;
        this.rounds = rounds;
        this.gameView = new GameView();
    }

    public void raceStart() {
        gameView.getRaceResult();

        for (int i = 0; i < rounds; i++) {
            for (Car car : carList) {
                car.move(pickNumberInRange(0, 9));
                gameView.getMovingResult(car);
            }
            System.out.println();
        }
    }

    public void getRaceWinner() {
        int maxPosition = carList.stream().mapToInt(Car::getPosition).max().orElse(0);

        List<String> winnerName = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        gameView.getRaceWinner(winnerName);
    }
}
