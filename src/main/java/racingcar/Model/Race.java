package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

import racingcar.View.RacingCarView;

public class Race {
    private List<RacingCar> racingCars;
    private int rounds;
    private RacingCarView view;

    public Race(List<RacingCar> racingCars, int rounds, RacingCarView view) {
        validateRounds(rounds);
        this.racingCars = racingCars;
        this.rounds = rounds;
        this.view = view;
    }

    private void validateRounds(int rounds2) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0이상이여야 합니다.");
        }
    }

    public void run() {
        for (int i = 0; i < rounds; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.move();
            }
            view.printRaceResult(racingCars, i, rounds);
            System.out.println();
        }
    }

    public List<RacingCar> getCars() {
        return racingCars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() == maxPosition) {
                winners.add(racingCar.getName());
            }
        }
        return winners;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > maxPosition) {
                maxPosition = racingCar.getPosition();
            }
        }
        return maxPosition;
    }
}
