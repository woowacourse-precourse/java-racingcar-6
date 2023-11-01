package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.MessageType;

public class RacingController {
    private static final int SMALLEST_RANDOM_NUMBER = 0;
    private static final int LARGEST_RANDOM_NUMBER = 9;
    private static final String COMMA_WITH_SPACE = ", ";

    public void start() {
        List<Car> carList = makeCar();
        int numberOfAttempts = getNumberOfAttempts();
        MessageType.printResult();

        for (int count = 0; count < numberOfAttempts; count++) {
            play(carList);
            showResult(carList);
        }
        showWinner(carList);
    }

    private List<Car> makeCar() {
        MessageType.printAskCarNames();
        CarName carName = new CarName(Console.readLine());
        List<String> carNameList = carName.getCarNameList();
        List<Car> carList = new ArrayList<>();

        for (int idx = 0; idx < carNameList.size(); idx++) {
            Car car = new Car(carNameList.get(idx));
            carList.add(car);
        }
        return carList;
    }

    private int getNumberOfAttempts() {
        MessageType.printNumberOfAttempts();
        Attempt attempt = new Attempt(Console.readLine());
        MessageType.printLineBreak();

        return attempt.getNumber();
    }

    private void play(List<Car> carList) {
        for (Car car : carList) {
            car.move(Randoms.pickNumberInRange(SMALLEST_RANDOM_NUMBER, LARGEST_RANDOM_NUMBER));
        }
    }

    private void showResult(List<Car> carList) {
        for (Car car : carList) {
            MessageType.printInputCarName(car.getName());
            MessageType.printCarLocation(car.getLocationString());
        }
        MessageType.printLineBreak();
    }

    private void showWinner(List<Car> carList) {
        int farthestCarLocation = Winner.findFarthestCarLocation(carList);

        List<String> winnerList = Winner.winnerList(carList, farthestCarLocation);
        MessageType.printWinner();
        String winnerStr = String.join(COMMA_WITH_SPACE, winnerList);
        MessageType.printWinnerNames(winnerStr);
    }
}
