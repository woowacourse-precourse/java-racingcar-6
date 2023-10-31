package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RacingCarGame {

    static List<String> getCarNames() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNamesInput = readLine();

        String[] carNamesArray = carNamesInput.split(",");

        List<String> carNamesList = new ArrayList<>();

        for (String s : carNamesArray) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }

            if (carNamesList.contains(s)) {
                throw new IllegalArgumentException();
            }

            carNamesList.add(s);
        }

        return carNamesList;
    }

    static int getPlayNum() throws IOException {
        System.out.println("시도할 횟수는 몇회인가요?");

        String playNumberInput = readLine();

        int playnum = Integer.parseInt(playNumberInput);

        if(playnum <= 0) {
            throw new IllegalArgumentException();
        }

        return playnum;
    }

    static Integer carMoveForwardResult(Integer lastPosition) {
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
            carResultList.set(i, carMoveForwardResult(carResultList.get(i)));
            System.out.print(carNamesList.get(i) + " : ");
            printRaceResult(carResultList.get(i));
        }

        return carResultList;
    }

    static List<String> getWinner(List<String> carNamesList, List<Integer> raceResultList) {
        Integer max = Collections.max(raceResultList);
        List<Integer> winnerIndex = new ArrayList<>();
        List<String> winnerNames = new ArrayList<>();

        for (int i = 0; i < raceResultList.size(); i++) {
            if (Objects.equals(raceResultList.get(i), max)) {
                winnerIndex.add(i);
            }
        }

        for (Integer index : winnerIndex) {
            winnerNames.add(carNamesList.get(index));
        }

        return winnerNames;
    }

    static void printWinner(List<String> winnerNames) {
        String winnerOutput = String.join(",", winnerNames);

        System.out.println("최종 우승자 : " + winnerOutput);
    }

    static void doRace(List<String> carNamesList, int playNumber) {
        List<Integer> raceResultList = new ArrayList<>();
        List<String> winnerNames;

        for (int i = 0; i < carNamesList.size(); i++) {
            raceResultList.add(0);
        }

        for (int i = 0; i < playNumber; i++) {
            raceResultList = raceResult(carNamesList, raceResultList);
            System.out.println();
        }

        winnerNames = getWinner(carNamesList, raceResultList);

        printWinner(winnerNames);
    }

    public static void playGame() {

        List<String> carNamesList;
        int playNumber;

        try {
            carNamesList = getCarNames();
            playNumber = getPlayNum();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        doRace(carNamesList, playNumber);
    }
}
