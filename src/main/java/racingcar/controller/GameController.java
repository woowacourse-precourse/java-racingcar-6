package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

// 사용자로부터 값을 입력받고 결과를 출력하기 위한 클래스
public class GameController {
    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameArr = Console.readLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        String frequency = Console.readLine();

        // checkValidation

        // implement Logic
    }
}
