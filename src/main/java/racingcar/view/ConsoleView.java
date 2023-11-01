package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class ConsoleView {
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }

    public int readMovement() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printGameStartMessage() {
        System.out.println("실행 결과" + "\n");
    }

    public void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getMoveHyphen());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}