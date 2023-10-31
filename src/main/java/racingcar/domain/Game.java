package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.Message;

import java.util.*;

public class Game {
    private static final int SMALLEST_RANDOM_NUMBER = 0;
    private static final int LARGEST_RANDOM_NUMBER = 9;
    private static final String COMMA_WITH_SPACE = ", ";

    public void start() {
        List<Car> carList = makeCar();
        int numberOfAttempts = getNumberOfAttempts();
        Message.printResultGuidance();

        for (int count = 0; count < numberOfAttempts; count++) {
            play(carList);
            showResult(carList);
        }
        showWinner(carList);
    }

    private List<Car> makeCar() {
        Message.printAskCarNames();
        CarName carName = new CarName(Console.readLine());
        List<String> carNameList = carName.getCarNameStrList();
        List<Car> carList = new ArrayList<>();

        for (int idx = 0; idx < carNameList.size(); idx++) {
            Car car = new Car(carNameList.get(idx));
            carList.add(car);
        }
        return carList;
    }

    private int getNumberOfAttempts() {
        Message.printNumberOfAttempts();
        Attempt attempt = new Attempt(Console.readLine());
        Message.printLineBreak();

        return attempt.getNumber();
    }

    private void play(List<Car> carList) {
        for (Car car : carList) {
            car.move(Randoms.pickNumberInRange(SMALLEST_RANDOM_NUMBER, LARGEST_RANDOM_NUMBER));
        }
    }

    private void showResult(List<Car> carList) {
        for (Car car : carList) {
            Message.printInputCarName(car.getName());
            Message.printCarPosition(car.getPositionString());
        }
        Message.printLineBreak();
    }

    private void showWinner(List<Car> carList) {
        int farthestCarPosition = Winner.findFarthestCarPosition(carList);

        List<String> winnerList = Winner.winnerList(carList, farthestCarPosition);
        Message.printWinnerGuidance();
        String winnerStr = String.join(COMMA_WITH_SPACE, winnerList);
        Message.printWinnerNames(winnerStr);
    }
}
