package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final String RESULT_MESSAGE = "실행 결과";
    private int count = 0;

    private List<Car> cars = new ArrayList<>();
    private InputSystem inputSystem = new InputSystem();
    private Winners winners = new Winners();


    public void userInput() {
        inputSystem.inputCarName(cars);
        count = inputSystem.inputTryCNT();
    }

    public void gameSystem() {
        System.out.println(RESULT_MESSAGE);
        while(winners.getWinnersCount() == 0) {
            for (Car car : cars) {
//                randomNumber();
                car.moving(randomNumber());
                System.out.println(car.getNowCarPosition());
                newWinner(car.getName(), car.getPosition());
            }
            System.out.println();
        }
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    private void newWinner(String name, int position) {
        if (position == count) {
            winners.addWinner(name);
        }
    }

    public void printWinners() {
        System.out.println("최종 우승자 : " + winners.toString());
    }
}
