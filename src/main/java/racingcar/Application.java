package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNamesArrayList = UserInput.getCarNames();

        System.out.println("시도할 회수는 몇회인가요?");
        int trialNumber = UserInput.getTrialNumber();
        System.out.println();

        System.out.println("실행 결과");
        Map<String, List<String>> raceResult = new HashMap<>();
        for (int i = 0; i < trialNumber; i++) {
            raceResult = Race.doRace(carNamesArrayList);
            Race.showRace(raceResult);
        }

        List<String> winnersArrayList;
        winnersArrayList = Winner.pickWinners(raceResult);
        Winner.showWinners(winnersArrayList);


    }
}
