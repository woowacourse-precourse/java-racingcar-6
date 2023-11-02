package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        InputCarName inputCarName = new InputCarName();
        List<Car> carList = inputCarName.inputCar(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTurn = Console.readLine();
        InputTurnNum inputTurnNum = new InputTurnNum();
        inputTurnNum.inputTurn(inputTurn, carList);

    }
}
