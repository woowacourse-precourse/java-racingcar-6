package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> carNamesList = splitCarNames(carNames);
        checkNamingError(carNamesList);

        System.out.println("시도할 회수는 몇회인가요?");
        String numberOfRacesStr = Console.readLine();
        int numberOfRaces = convertStringToInt(numberOfRacesStr);

        System.out.println("실행 결과");
        List<Integer> raceResult = playCarRace(numberOfRaces, carNamesList);
        List<String> winnerNameList = decideWinner(raceResult, carNamesList);
        printWinner(winnerNameList);
    }

    public static List<String> splitCarNames(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    public static void checkNamingError(List<String> carNamesList) {
        int maxLength = 5;
        for (String name : carNamesList) {
            if (name.length() > maxLength) {
                throw new IllegalArgumentException("이름 길이 5자 초과");
            }
        }
    }

    public static int convertStringToInt(String numberOfRacesStr) {
        try {
            return Integer.parseInt(numberOfRacesStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    public static List<Integer> playCarRace(int numberOfRaces, List<String> carNamesList) {
        List<Integer> recordStorage = new ArrayList<>(Collections.nCopies(carNamesList.size(), 0));

        for (int i = 0; i < numberOfRaces; i++) {
            recordStorage = recordCarAction(carNamesList, recordStorage);
            printCarRace(carNamesList, recordStorage);
        }
        return recordStorage;
    }

    public static List<Integer> recordCarAction(List<String> carNamesList, List<Integer> recordStorage) {
        for (String car : carNamesList) {
            int i = carNamesList.indexOf(car);
            int action = recordStorage.get(i) + generateAction();
            recordStorage.set(i, action);
        }
        return recordStorage;
    }

    public static int generateAction() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        int action = 0;
        if (randomNumber >= 4) {
            action++;
        }
        return action;
    }

    public static void printCarRace(List<String> carNamesList, List<Integer> recordStorage) {
        for (String car : carNamesList) {
            int i = carNamesList.indexOf(car);
            int action = recordStorage.get(i);
            String dashes = "-".repeat(action);
            System.out.println(car + " : " + dashes);
        }
        System.out.println();
    }

    public static List<String> decideWinner(List<Integer> raceResult, List<String> carNamesList) {
        List<Integer> winnerIndexList = extractWinnerIndex(raceResult);
        List<String> winnerNameList = new ArrayList<>();
        for (int winnerIndex : winnerIndexList) {
            String winnerName = carNamesList.get(winnerIndex);
            winnerNameList.add(winnerName);
        }
        return winnerNameList;
    }

    public static List<Integer> extractWinnerIndex(List<Integer> raceResult) {
        int maxDistance = Collections.max(raceResult);
        List<Integer> winnerIndexList = new ArrayList<>();
        for (int i = 0; i < raceResult.size(); i++) {
            if (raceResult.get(i) == maxDistance) {
                winnerIndexList.add(i);
            }
        }
        return winnerIndexList;
    }

    public static void printWinner(List<String> winnerNameList) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerNameList.size(); i++) {
            String winnerName = String.valueOf(winnerNameList.get(i));
            System.out.print(winnerName);
            if (i + 1 < winnerNameList.size()) {
                System.out.print(", ");
            }
        }
    }
}
