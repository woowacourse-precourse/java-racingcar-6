package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.List;

public class GameView {
    public void promptForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
    }

    public int promptForNumberOfAttempts() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void displayRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getCarPosition(car.getPosition()));
        }
        System.out.println();
    }

    public void displayWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private String getCarPosition(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}