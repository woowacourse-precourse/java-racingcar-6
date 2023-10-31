package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RacingGame {
    public void run() {
        final List<Car> carList = InputProcess.inputCarNames();
        final int count = InputProcess.inputCountNum();

        for(int i =0; i< count; i++) {
            tryOneStep(carList);
            printRaceState(carList);
        }

        printWinners(findWinners(carList));
    }

    private void tryOneStep(List<Car> carList) {
        for(Car car : carList) {
            if (Randoms.pickNumberInRange(0, 9) >= 4)
                car.stepForward();
        }
    }

    private void printWinners(List<Car> winnerList) {
        Iterator<Car> winnerItr = winnerList.iterator();

        System.out.print("최종 우승자 : ");
        winnerItr.next().printName();
        while(winnerItr.hasNext()) {
            System.out.print(", ");
            winnerItr.next().printName();
        }
    }

    private List<Car> findWinners(List<Car> carList) {
        int maxStep = 0;
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getStep() == maxStep)
                winners.add(car);
            if(car.getStep() > maxStep) {
                winners.clear();
                winners.add(car);
                maxStep = car.getStep();
            }
        }
        return winners;
    }

    private void printRaceState(List<Car> carList) {
        for (Car car : carList) {
            car.printStepState();
        }
        System.out.println();
    }
}
