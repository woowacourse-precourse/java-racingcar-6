package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.Car;

import java.util.List;

public class RacingGameView {

    public List<String> getCarNames() {
        System.out.println("자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = Console.readLine();
        return List.of(input.split(","));
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printRoundResult(List<Car> cars) {
        System.out.println("\n각 자동차의 상태:");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
