package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.math.BigInteger;
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
        outputLine("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static void outputStartRacing () {
        outputLine("");
        outputLine("실행 결과");
    }

    public static void outputScoreState (ArrayList<Car> carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.name).append(" : ");
            BigInteger score = car.score;
            for (BigInteger j = BigInteger.ZERO; j.compareTo(score) < 0; j = j.add(BigInteger.ONE)) {
                sb.append("-");
            }
            sb.append("\n");
        }
        outputLine(sb);
    }

    public static void outputFinish (Object winner) {
        output("최종 우승자 : ");
        outputLine(winner);
    }
}