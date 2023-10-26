package racingcar.implementation;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.function.BiConsumer;

public class RacingGame {
    private Map<String, String> carMap;
    private int numberOfTry;

    private UserInput userInput;
    private RandomBooleanGenerator generator;

    public RacingGame() {
        this.userInput = new UserInput();
        this.generator = new RandomBooleanGenerator();
    }

    public void entireProcess() {
        getUserInput();

        System.out.println("실행 결과");

        for (int i = 0; i < numberOfTry; i++) {
            oneEpoch();
            printProcess();
        }

        printWinner();
    }

    private void getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carMap = userInput.getCarList();

        System.out.println("시도할 회수는 몇회인가요?");
        numberOfTry = userInput.getNumberOfTry();

        System.out.println();
    }

    private void oneEpoch() {
        carMap.forEach((car, length) -> {
            boolean goOrStopVal = generator.randomBooleanGenerator();

            if (goOrStopVal) {
                length += "-";
            }
        });
    }

    private void printProcess() {
        carMap.forEach((car, length) -> {
            System.out.println(car + " : " + length);
        });

        System.out.println();
    }

    private void printWinner() {
        Map<Integer, List<String>> resultOfRacing = getResult();
        List<String> winners = new ArrayList<>();

        for (int i = numberOfTry; i > 0; i--) {
            List<String> candidates = resultOfRacing.get(i);
            if (candidates.size() > 0) {
                winners = candidates;
                break;
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private Map<Integer, List<String>> getResult() {
        Map<Integer, List<String>> resultOfRacing = new HashMap<>();

        for (int i = 0; i < numberOfTry; i++) {
            resultOfRacing.put(i, new ArrayList<>());
        }

        carMap.forEach((car, length) -> {
            resultOfRacing.get(length.length()).add(car);
        });

        return resultOfRacing;
    }
}
