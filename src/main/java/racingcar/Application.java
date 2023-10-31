package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<String> carNamesArrayList = enterCarNames();

        int trialNumber = enterTrialNumber();

        Map<String, String> raceResultsHMap = runRace(carNamesArrayList, trialNumber);

        showRaceResult(raceResultsHMap);
    }


    private static List<String> enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> carNamesArrayList = UserInput.getCarNames();

        return carNamesArrayList;
    }


    private static int enterTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");

        int trialNumber = UserInput.getTrialNumber();

        System.out.println();

        return trialNumber;
    }


    private static Map<String, String> runRace(List<String> carNamesArrayList, int trialNumber) {
        System.out.println("실행 결과");

        Map<String, String> raceResultsHMap = new LinkedHashMap<>();

        Map<String, String> readyForRaceHMap = Race.registerCars(carNamesArrayList);
        for (int i = 0; i < trialNumber; i++) {
            raceResultsHMap = Race.doRace(readyForRaceHMap);
            Race.showRace(raceResultsHMap);
        }

        return raceResultsHMap;
    }


    private static void showRaceResult(Map<String, String> raceResultsHMap) {
        List<String> winnersArrayList = Winner.pickWinners(raceResultsHMap);
        Winner.showWinners(winnersArrayList);
    }


}
