package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameController {

    GameModel gameModel = new GameModel();
    GameView gameView = new GameView();
    Map<String, Integer> carData = new LinkedHashMap<>();

    public void insertCarToCarArray(String[] carNamesArray) {
        for (String carName : carNamesArray) {
            carData.put(carName, 0);
        }
    }

    public void askHowManyTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void run() {
        printStartMessage();
        String[] carNamesArray = Console.readLine().split(",");
        insertCarToCarArray(carNamesArray);

        askHowManyTimes();
        int count = Integer.parseInt(Console.readLine());

        for (String carName : carData.keySet()) {
            for (int j = 0; j < count; j++) {
                int randInt = Randoms.pickNumberInRange(0, 9);
                if (randInt >= 4) {
                    carData.put(carName, carData.get(carName) + 1);
                }
            }
        }

        System.out.println("실행 결과");
        for (Map.Entry<String, Integer> entry : carData.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int j = 0; j < entry.getValue(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }

        // 최대값 찾기
        int maxPosition = carData.values().stream().max(Integer::compare).orElse(0);

        // 최대값과 일치하는 자동차 이름 찾기
        ArrayList<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : carData.entrySet()) {
            if (entry.getValue().equals(maxPosition)) {
                winners.add(entry.getKey());
            }
        }

        // 우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }
}
