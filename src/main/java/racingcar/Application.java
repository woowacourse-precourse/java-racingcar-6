package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        // 자동차 경주 게임 시작
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNameList = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        String iterStr = Console.readLine();

        RacingCarController racingCarController = new RacingCarController(inputCarNameList, iterStr);
    }
}
