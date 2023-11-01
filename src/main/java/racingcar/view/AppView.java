package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import java.util.ArrayList;

public class AppView {
    private AppView() {
    }

    public static void output (String message) {
        System.out.print(message);
    }
    public static void outputLine (Object message) {
        System.out.println(message);
    }

    public static String inputParticipant () {
        outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String inputNumberOfTurns () {
        outputLine("시도할 횟수는 몇회인가요?");
        return Console.readLine();
    }

    public static void outputStartRacing () {
    }

    public static void outputScoreState (ArrayList<Car> carList) {
    }

    public static void outputFinish (Object winner) {
    }
}