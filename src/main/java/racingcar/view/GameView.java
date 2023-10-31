package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class GameView {

    public String[] inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        return userInput.split(",");
    }

    public int inputNumberGames() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }

    public void printResult(Cars cars) {
        System.out.println(cars);
    }

    public void printWinner(String winnersName) {
        System.out.println("최종 우승자 : " + winnersName);
    }
}
