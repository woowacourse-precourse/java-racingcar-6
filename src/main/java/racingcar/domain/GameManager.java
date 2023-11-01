package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.IoManager;
import racingcar.firstClassCollection.RoundTryCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameManager {
    private RoundTryCount roundTryCount;
    private List<Car> cars;

    public void gameStart() {

    }

    public void receiveRoundTryCount() {
        IoManager.printEnterRoundTryCount();
        int roundTryCount = Integer.parseInt(Console.readLine());
        this.roundTryCount = new RoundTryCount(roundTryCount);
    }

    public void proceedRound() {
        IoManager.printResultMessage();
        while (roundTryCount.isRemainRound()) {
            roundTryCount.consumeRound();
            for (Car car : cars) {
                car.proceedOwnRound();
                IoManager.println(car.getFormattedPostion());
            }
            IoManager.printEmptyLine();
        }

    }

    public void printWinner() {
        sortCars();
        List<String> winners = getWinnerList(cars);
        IoManager.print("최종 우승자: " + String.join(", ", winners));
    }

    public void sortCars() {
        cars.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
    }
    public List<String> getWinnerList(List<Car> cars){
        int firstWinnerPosition = cars.get(0).getPosition();
        List<String> winners = new ArrayList<String>();
        for (Car car : cars) {
            if (car.getPosition() == firstWinnerPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
