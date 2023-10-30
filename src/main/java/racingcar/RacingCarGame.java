package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RacingCarGame {

    static Integer carMoveFowardResult(Integer lastPosition) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return lastPosition + 1;
        }

        return lastPosition;
    }

    static void printRaceResult(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    static List<Integer> raceResult(List<String> carNamesList, List<Integer> carResultList) {
        for (int i = 0; i < carNamesList.size(); i++) {
            carResultList.set(i, carMoveFowardResult(carResultList.get(i)));
            System.out.print(carNamesList.get(i) + ": ");
            printRaceResult(carResultList.get(i));
        }

        return carResultList;
    }

    public static void playGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNamesInput = readLine();

        String[] carNamesArray = carNamesInput.split(",");

        List<String> carNamesList = new ArrayList<>();

        for (String s : carNamesArray) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }

            carNamesList.add(s);
        }

        System.out.println("시도할 횟수는 몇회인가요?");

        String playNumberInput = readLine();
        int playNumber = Integer.parseInt(playNumberInput);

        List<Integer> raceResultList = new ArrayList<>();

        for (int i = 0; i < carNamesList.size(); i++) {
            raceResultList.add(0);
        }

        for (int i = 0; i < playNumber; i++) {
            raceResultList = raceResult(carNamesList, raceResultList);
            System.out.println();
        }

        Integer max = Collections.max(raceResultList);
        List<Integer> winnerIndex = new ArrayList<>();
        List<String> winnerNames = new ArrayList<>();

        for (int i = 0; i < raceResultList.size(); i++) {
            if (Objects.equals(raceResultList.get(i), max)) {
                winnerIndex.add(i);
            }
        }

        for (int i = 0; i < winnerIndex.size(); i++) {
            winnerNames.add(carNamesList.get(winnerIndex.get(i)));
        }

        String winnerOutput = String.join(",", winnerNames);

        System.out.println("최종 우승자 : " + winnerOutput);
    }
}
