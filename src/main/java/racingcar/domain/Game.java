package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.Message;

import java.util.*;

public class Game {
    public void start() {
        List<Car> carList = makeCar();
        int numberOfAttempts = getNumberOfAttempts();
        System.out.println("실행 결과");

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
            car.move(Randoms.pickNumberInRange(0, 9));
        }

    }

    private void showResult(List<Car> carList) {
        for (Car car : carList) {
            Message.printInputCarName(car.getName());
//            System.out.print(car.getName() + " : ");
            Message.printCarPosition(car.getPositionString());
//            System.out.println(car.getPosition());
        }
        Message.printLineBreak();
//        System.out.println();
    }

    private void showWinner(List<Car> carList) {
        int farthestCarPosition = Winner.findFarthestCarPosition(carList);

        List<String> winnerList = Winner.winnerList(carList, farthestCarPosition);
//        System.out.print("최종 우승자 : ");
        Message.printWinnerGuidance();
        String winnerStr = String.join(", ", winnerList);
//        System.out.println(winnerStr);
        Message.printWinnerNames(winnerStr);
    }

}
