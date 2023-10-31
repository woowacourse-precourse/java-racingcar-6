package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingController {
    private CarRepository carRepository = CarRepository.getInstance();
    private RacingCarView view = new RacingCarView();

    public void setRacingResults(int racingCount) {
        view.printResultMessage();
        for (int i = 0; i < racingCount; i++) {
            setGoNStop(carRepository.findCarList());
            printRacingResult();
        }
    }

    public void setGoNStop(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            if (canGo())
                carList.get(i).move();
        }
    }

    public boolean canGo() {
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            return true;
        return false;
    }

    public void printRacingResult() {
        view.printRacing(carRepository.findCarList());
    }

    public void printWinner() {
        String[] winner = findWinner();
        view.printWinner(winner);
    }

    public String[] findWinner() {
        int max = findMax();
        List<String> winnerList = new ArrayList<String>();

        for (Car c : carRepository.findCarList()) {
            if (c.getMove() == max)
                winnerList.add(c.getName());
        }
        return winnerList.toArray(new String[winnerList.size()]);
    }

    public int findMax() {
        int max = 0;
        for (Car c : carRepository.findCarList())
            if (max <= c.getMove())
                max = c.getMove();
        return max;
    }

}
