package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String cars = getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> carList = getCarList(cars);

        Map<String, Integer> carMap = getCarMap(carList);

        String tryCountString = getInput("시도할 회수는 몇회인가요?");

        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(tryCountString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        System.out.println("실행 결과");
        System.out.println();

        for (int i = 0; i < tryCount; i++) {
            moveCars(carList, carMap);
            printCurrentStatus(carMap);
            System.out.println();
        }

        int maxScore = getMaxScore(carMap);

        List<String> winners = getWinners(carMap, maxScore);

        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    private static List<String> getWinners(Map<String, Integer> carMap, int maxScore) {
        List<String> winners = new ArrayList<>();
        // 최고 점수를 가진 우승자를 찾음
        for (Map.Entry<String, Integer> entry : carMap.entrySet()) {
            String car = entry.getKey();
            int score = entry.getValue();
            if (score == maxScore) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getMaxScore(Map<String, Integer> carMap) {
        int maxScore = 0;

        for (Map.Entry<String, Integer> entry : carMap.entrySet()) {
            int score = entry.getValue();
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }

    private static void printCurrentStatus(Map<String, Integer> carMap) {
        for (Map.Entry<String, Integer> entry : carMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < entry.getValue(); k++) {
                sb.append("-");
            }

            System.out.println(String.format("%s : %s", entry.getKey(), sb.toString()));
        }
    }

    private static void moveCars(List<String> carList, Map<String, Integer> carMap) {
        for (int j = 0; j < carList.size(); j++) {
            var random = Randoms.pickNumberInRange(0, 9);

            if (random >= 4) {
                int currentValue = carMap.get(carList.get(j));
                carMap.put(carList.get(j), currentValue + 1);
            }
        }
    }

    private static String getInput(String message) {
        System.out.println(message);
        String getData = Console.readLine();
        return getData;
    }

    private static List<String> getCarList(String carsString) {
        List<String> carList = Arrays.asList(carsString.split(","));

        for (String car : carList) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }

            if (car.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }

        return carList;
    }

    private static Map<String, Integer> getCarMap(List<String> carList) {
        Map<String, Integer> carMap = new LinkedHashMap<>();
        for (int i = 0; i < carList.size(); i++) {
            carMap.put(carList.get(i), 0);
        }

        return carMap;
    }

}
