package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.model.Cars.generateCar;
import static racingcar.view.InputView.generateCarNameInput;
import static racingcar.view.InputView.generateTryCountInput;
import static racingcar.view.OutputView.processResult;


public class GameController {
    private static int tryCount;
    private static List<Car> carsList;
    private static List<Car> winnerList;

    public static void startGame() { // 뷰는 컨트롤러에만 의존한다.
        carsList = generateCar(generateCarNameInput());
        tryCount = generateTryCountInput();
        processResult();
        while (tryCount-- > 0) {
            for (Car car : carsList) {
                GameNumber gameNumber = new GameNumber();
                int length = car.checkProcess(gameNumber.generateRandomNumber());
                String process = makeProcessBar(length);
                System.out.println(car.getName() + " : " + process);
            }
            System.out.println();

        }
        winnerList = findWinners(carsList);
        OutputView.GameResult();
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.println(winnerList.get(i).getName());
        }
    }

    private static String makeProcessBar(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    private static List<Car> findWinners(List<Car> carsList) {
        List<Car> winners = new ArrayList<>();
        int maxCarLength = -1;
        for (Car car : carsList) {
            if (car.getLength() > maxCarLength) {
                maxCarLength = car.getLength();
                winners.clear();
                winners.add(car);
            } else if (car.getLength() == maxCarLength) {
                winners.add(car);
            }
        }
        return winners;
    }


}
