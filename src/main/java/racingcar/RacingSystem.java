package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingSystem {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private InputSystem inputSystem = new InputSystem();
    private List<Car> cars = new ArrayList<>();
    private Winners winners = new Winners();
    private int cnt = 0;

    public RacingSystem() {
    }

    public Winners getWinners() {
        return winners;
    }

    public void input() {
        inputSystem.inputCarName(cars);
        cnt = inputSystem.inputTryCount();
    }

    public void racingStart() {
        System.out.println("\n" + "실행 결과");
        while (cnt > 0) {
            for (Car car : cars) {
                int random = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
                car.go(random);
                System.out.println(car.getCarStatus());
            }
            System.out.println();
            cnt--;
        }
        putWinner();
    }

    public void printWinners() {
        System.out.println("최종 우승자 : " + winners.toString());
    }

    private void putWinner() {
        int maxPosition = -1;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.addWinner(car.getName());
            }
        }

    }

}
