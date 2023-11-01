package racingcar.view;

import java.util.List;
import racingcar.util.Constants;

public class TextInterface {
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askRacingcarRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void startRound() {
        System.out.println("실행 결과");
    }

    public void carStatus(String name, int distance) {
        String totalDistance = Constants.DISTANCE_STRING.repeat(distance);
        String nowStatus = String.format("%s : %s", name, totalDistance);
        System.out.println(nowStatus);
    }

    public void printResult(List<String> names) {
        String winnersName = String.join(", ", names);
        String result = String.format("최종 우승자 : %s", winnersName);
        System.out.println(result);
    }
}
