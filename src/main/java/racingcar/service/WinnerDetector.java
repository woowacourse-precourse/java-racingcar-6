package racingcar.service;

import racingcar.domain.Cars;
import racingcar.repository.WinnerRepository;

public class WinnerDetector {
    private final PrintService print = new PrintService();
    private final WinnerRepository winnerRepo = new WinnerRepository();
    private final Cars cars = Cars.create();

    public void findNum() {
        winnerRepo.saveNum(cars.findMaxPosition());
    }

    public void findName() {
        for (int i = 0; i < cars.size(); i++) {
            if (winnerRepo.isWinner(cars.getPosition(i))) {
                winnerRepo.add(cars.getName(i));
            }
        }
    }

    public void displayResult() {
        print.winner(winnerRepo.convertListToString());
    }
}
