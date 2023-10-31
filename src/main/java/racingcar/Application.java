package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.CarController;
import racingcar.util.Log;

public class Application {

    private final CarController carController = new CarController();
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Log.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        Log.println("시도할 회수는 몇회인가요?");
        String tryingCount = Console.readLine();
        Log.println("실행 결과");

        Log.print("최종 우승자 : ");

    }
}
