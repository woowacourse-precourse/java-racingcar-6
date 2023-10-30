package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<String> carNamesList = new ArrayList<>();
    private List<Integer> scoreList = new ArrayList<>();

    public void roundResult() {
        for (int i = 0; i < scoreList.size(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                scoreList.set(i, scoreList.get(i) + 1);
            }
        }
    }

    public void displayResult() {
        for (int i = 0; i < scoreList.size(); i++) {
            System.out.println(carNamesList.get(i) + " : " + "-".repeat(scoreList.get(i)));
        }
        System.out.println();
    }

    public void findWinner() {
        int maxScore = scoreList.stream().mapToInt(Integer::intValue).max().orElseThrow();
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < scoreList.size(); i++) {
            if (scoreList.get(i) == maxScore) {
                winners.add(carNamesList.get(i));
            }
        }
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    public static void main(String[] args) {
        Application carRace = new Application();

        System.out.println("경주 할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분, 각 이름은 5자 이내)");
        String carNames = Console.readLine();
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            String trimmedName = carName.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이내여야 합니다.");
            }
            carRace.carNamesList.add(trimmedName);
            carRace.scoreList.add(0);
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        int rounds = Integer.parseInt(Console.readLine());
        for (int i = 0; i < rounds; i++) {
            carRace.roundResult();
            carRace.displayResult();
        }

        carRace.findWinner();
    }
}

