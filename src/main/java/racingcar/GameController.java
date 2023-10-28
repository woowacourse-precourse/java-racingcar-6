package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameController {

    GameModel gameModel = new GameModel();
    GameView gameView = new GameView();
    Map<String, Integer> carData;

    public GameController() {
        carData = new LinkedHashMap<>();
    }

    public void insertCarToCarArray(Map<String, Integer> carData, String[] carNamesArray) {
        for (String carName : carNamesArray) {
            carData.put(carName, 0);
        }
    }

    public void askHowManyTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean checkResult(int randInt) {
        return randInt >= 4;
    }
    public void putDataToCarData(String carName, int count) {
        carData.put(carName, carData.get(carName) + count);
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public int findMaxPosition(Map<String, Integer> carData) {
        return carData.values().stream().max(Integer::compare).orElse(0);
    }

    public void carPrepare(Map<String, Integer> carData) {
        printStartMessage();
        String[] carNamesArray = Console.readLine().split(",");
        insertCarToCarArray(carData, carNamesArray);
    }

    public void saveResult(Map<String, Integer>carData, int count) {
        for (String carName : carData.keySet()) {
            for (int j = 0; j < count; j++) {
                int randInt = createRandomNumber();
                if (checkResult(randInt)) {
                    putDataToCarData(carName, 1);
                }
            }
        }
    }

    public void printResult(Map<String, Integer> carData) {
        for (Map.Entry<String, Integer> entry : carData.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int j = 0; j < entry.getValue(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void displayGameResult(Map<String, Integer> carData) {
        printResultMessage();
        printResult(carData);
    }

    public void playingGame(Map<String, Integer> carData) {
        askHowManyTimes();
        int count = Integer.parseInt(Console.readLine());
        saveResult(carData, count);
    }

    public void findWinner(Map<String, Integer> carData) {
        int maxPosition = findMaxPosition(carData);
        ArrayList<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : carData.entrySet()) {
            if (entry.getValue().equals(maxPosition)) {
                winners.add(entry.getKey());
            }
        }
        printWinner(winners);
    }
    public void run() {

        carPrepare(carData);
        playingGame(carData);
        displayGameResult(carData);
        findWinner(carData);
    }

    public void printWinner(ArrayList<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }
}
