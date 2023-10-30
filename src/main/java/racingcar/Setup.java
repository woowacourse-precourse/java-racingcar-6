package racingcar;

import camp.nextstep.edu.missionutils.Console;
// - [ ] 사용자가 총 게임 진행 횟수와 자동차 이름을 입력한다. - racingcar#SetUp
public class Setup {
    public String createNewGame () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerCars = Console.readLine();
    }
}
