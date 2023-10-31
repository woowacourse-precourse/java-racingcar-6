package racingcar.service;

import racingcar.repository.CarsRepository;
import racingcar.repository.WinnerRepository;

public class WinnerDetector {
    private final PrintService print = new PrintService();
    private final CarsRepository carsRepository = new CarsRepository();
    private final WinnerRepository winnerRepository = new WinnerRepository();

    public void find() {
        add(carsRepository.findMaxPosition());
        print.winner(winnerRepository.convertListToString());
    }

    private void add(int max) {
        for (int i = 0; i < carsRepository.size(); i++) {
            if (max == carsRepository.getGameNum(i)) {
                winnerRepository.add(carsRepository.getName(i));
            }
        }
    }
}
