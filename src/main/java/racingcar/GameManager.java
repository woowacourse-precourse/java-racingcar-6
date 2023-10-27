package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameManager {

    public void gamePlay() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = UserInputReceiver.receiveCarNameAndGetCarNameList(Console.readLine());
        CarFactory.createCars(carNameList);
    }

}
