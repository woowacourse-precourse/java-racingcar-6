package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    static Integer carMoveFowardResult(Integer lastPosition) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return lastPosition + 1;
        }

        return lastPosition;
    }

    static void printRaceResult(Integer position) {
        for (int i = 0; i<position;i++) {
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

        return  carResultList;
    }

    public static void playGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNamesInput = readLine();

        String[] carNamesArray = carNamesInput.split(",");

        List<String> carNamesList = new ArrayList<>();

        for (String s : carNamesArray) {
            if (s.length() >= 5) {
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
    }
}
