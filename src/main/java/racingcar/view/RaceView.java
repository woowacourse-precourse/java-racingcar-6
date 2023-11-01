package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RaceView {

    private static RaceView raceView;

    private RaceView() {}

    public static RaceView getInstance() {
        if (raceView == null) {
            raceView = new RaceView();
        }
        return raceView;
    }

    public List<String> startGame() {
        List<String> raceInfo = new ArrayList<>(2);
        raceInfo.add(inputCarName());
        raceInfo.add(inputRaceChance());
        return raceInfo;
    }

    private String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private String inputRaceChance() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public void startRace() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void execRace(String status) {
        System.out.println(status);
    }

    public void finishRace(List<String> winners) {
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        for (String winner : winners) {
            sb.append(winner).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
