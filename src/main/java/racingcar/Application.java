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
        List<String> carNamesList = inputCarNames();
        checkNamingError(carNamesList);

        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfRaces = inputNumberOfRaces();

        System.out.println("실행 결과");
        List<Integer> raceResult = printCarRace(numberOfRaces, carNamesList);

        List<String> winnerNameList = decideWinner(raceResult, carNamesList);

        printWinner(winnerNameList);
    }

    public static List<String> inputCarNames() {
        String carNames = Console.readLine();
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

    public static int inputNumberOfRaces() {
        String numberOfRaces = Console.readLine();
        try {
            return Integer.parseInt(numberOfRaces);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    public static int generateAction() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        int action = 0;
        if (randomNumber >= 4) {
            action++;
        }
        return action;
    }

    public static List<Integer> recordCarAction(List<String> carNamesList) {
        List<Integer> carActionList = new ArrayList<>();
        for (String car : carNamesList) {
            carActionList.add(generateAction());
        }
        return carActionList;
    }

    public static List<Integer> printCarRace(int numberOfRaces, List<String> carNamesList) {
        int numberOfCars = carNamesList.size();
        List<Integer> totalActionList = new ArrayList<>(Collections.nCopies(numberOfCars, 0));

        for (int j = 0; j < numberOfRaces; j++) {
            List<Integer> carActionList = recordCarAction(carNamesList);

            for (int i = 0; i < numberOfCars; i++) {
                String car = carNamesList.get(i);
                int action = totalActionList.get(i) + carActionList.get(i);
                String dashes = "-".repeat(action);
                System.out.println(car + " : " + dashes);

                totalActionList.set(i, action);
            }
            System.out.println();
        }
        return totalActionList;
    }

    public static List<Integer> extractWinnerIndex(List<Integer> totalActionList) {
        int maxDistance = Collections.max(totalActionList);
        List<Integer> winnerIndexList = new ArrayList<>();
        for (int i = 0; i < totalActionList.size(); i++) {
            if (totalActionList.get(i) == maxDistance) {
                winnerIndexList.add(i);
            }
        }
        return winnerIndexList;
    }

    public static List<String> decideWinner(List<Integer> totalActionList, List<String> carNamesList) {
        List<Integer> winnerIndexList = extractWinnerIndex(totalActionList);
        List<String> winnerNameList = new ArrayList<>();
        for (int winnerIndex : winnerIndexList) {
            String winnerName = carNamesList.get(winnerIndex);
            winnerNameList.add(winnerName);
        }
        return winnerNameList;
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
