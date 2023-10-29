package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int trialNumber;
        List<String> carNamesArrayList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNamesArrayList = UserInput.getCarNames();

        System.out.println("시도할 회수는 몇회인가요?");
        trialNumber = UserInput.getTrialNumber();
        System.out.println();

        System.out.println("실행 결과");
        for (int i = 0; i < trialNumber; i++) {
            Map<String, List<String>> raceResult;
            raceResult = Race.doRace(carNamesArrayList);
            Race.showRace(raceResult);
        }



    }
}
