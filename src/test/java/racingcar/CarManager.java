package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CarManager {
    String[] carArray;
    public void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public void inputForCarName() {
        String carStr = Console.readLine();
        carArray = carStr.split(",");
    }

    public void printCarMovePrompt() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }
}