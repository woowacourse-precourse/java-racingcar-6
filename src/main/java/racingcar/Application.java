package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Application {

    public static Map<String, Integer> carDistanceMap(String carNameString) {

        Map<String, Integer> carDistanceMap = new LinkedHashMap<>();

        for (String carName : carNameString.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            carDistanceMap.put(carName, 0);
        }

        return carDistanceMap;
    }

    public static Map<String, Integer> movingCar(Map<String, Integer> carDistanceMap) {

        for (Map.Entry<String, Integer> carDistanceEntry : carDistanceMap.entrySet()) {

            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carDistanceMap.put(carDistanceEntry.getKey(), carDistanceEntry.getValue() + 1);
            }
        }

        return carDistanceMap;
    }

    public static String meterBuilder(Integer repeatCount) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < repeatCount; i++) {
            stringBuilder.append('-');
        }

        return stringBuilder.toString();
    }

    public static void printResult(Map<String, Integer> carDistanceMap) {

        for (Map.Entry<String, Integer> carDistanceEntry : carDistanceMap.entrySet()) {

            String meter = meterBuilder(carDistanceEntry.getValue());
            System.out.printf("%s : %s \n", carDistanceEntry.getKey(), meter);
        }
        System.out.println("");
    }

    public static String getWinner(Map<String, Integer> carDistanceMap) {

        ArrayList<String> winnerList = new ArrayList<>();

        Optional<Integer> maxDistance = carDistanceMap.values().stream().max(Integer::compareTo);

        for (Map.Entry<String, Integer> carDistanceEntry : carDistanceMap.entrySet()) {
            if (carDistanceEntry.getValue() == maxDistance.get()) {
                winnerList.add(carDistanceEntry.getKey());
            }
        }

        String winners = String.join(", ", winnerList);

        return winners;
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        Map<String, Integer> carDistanceMap = carDistanceMap(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        Integer repeatCount = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");

        for (int i = 0; i < repeatCount; i++) {

            carDistanceMap = movingCar(carDistanceMap);

            printResult(carDistanceMap);
        }

        String winners = getWinner(carDistanceMap);

        System.out.printf("최종 우승자 : %s\n", winners);
    }
}
