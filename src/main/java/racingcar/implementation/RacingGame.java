package racingcar.implementation;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.function.BiConsumer;

public class RacingGame {
    private List<String> carList;
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
        carList = userInput.getCarList();

        System.out.println("시도할 회수는 몇회인가요?");
        numberOfTry = userInput.getNumberOfTry();

        System.out.println();
    }

    private void oneEpoch() {
        for (int i = 0; i < carList.size(); i++) {
            if (generator.randomBooleanGenerator()) {
                carList.set(i, carList.get(i).concat("-"));
            }
        }
    }

    private void printProcess() {
        carList.forEach((car) -> {
            System.out.println(car);
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

        for (int i = 0; i <= numberOfTry; i++) {
            resultOfRacing.put(i, new ArrayList<>());
        }

        carList.forEach((car) -> {
            String carName = car.replace("-", "").replace(" : ", "");
            int moveLength = car.length() - carName.length() - 3;
            resultOfRacing.get(moveLength).add(carName);
        });

        return resultOfRacing;
    }
}
