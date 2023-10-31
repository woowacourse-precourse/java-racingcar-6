package racingcar.service;

import racingcar.repository.CarsRepository;
import racingcar.repository.WinnerRepository;

public class WinnerDetector {
    private final PrintService print = new PrintService();
    private final CarsRepository carsRepo = new CarsRepository();
    private final WinnerRepository winnerRepo = new WinnerRepository();

    public void findNum() {
        winnerRepo.saveNum(carsRepo.findMaxPosition());
    }

    public void findName() {
        for (int i = 0; i < carsRepo.size(); i++) {
            if (winnerRepo.isWinner(carsRepo.getPosition(i))) {
                winnerRepo.add(carsRepo.getName(i));
            }
        }
    }

    public void displayResult() {
        print.winner(winnerRepo.convertListToString());
    }
}
