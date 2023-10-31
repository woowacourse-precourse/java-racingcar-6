package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarValidator;
import racingcar.round.RoundValidator;

public class GameView {

    private static GameView gameView = new GameView();

    private GameView() {
    }

    public static GameView getInstance() {
        return gameView;
    }

    //사용자에게 자동차 이름 입력 받기
    public String[] carsInput() {
        System.out.println(Constant.START_NAME_MESSAGE);
        String userInput = Console.readLine();
        String[] carNames = userInput.split(",");
        CarValidator.carValidation(carNames);
        return carNames;
    }

    //사용자에게 시도활 횟수 입력 받기
    public String roundInput() {
        String round;
        do {
            System.out.println(Constant.START_NUMBER_MESSAGE);
            round = Console.readLine();
        } while (!RoundValidator.roundValidation(round));

        return round;
    }

    //실행 결과 출력하기
    public void printRound() {
        System.out.println();
        System.out.println(Constant.RESULT_MESSAGE);
    }

    //차수 별 결과 출력하기
    public void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printStatus(car.getPosition());
        }
        System.out.println();
    }

    //자동차 별 전진 개수 출력하기
    public void printStatus(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //게임 결과 출력하기
    public void printWinners(List<Car> winners) {
        System.out.print(Constant.WINNER_MESSAGE);
        for (int i = 0; i < winners.size(); i++) {
            if (i >= 1) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i).getName());
        }
    }
}
