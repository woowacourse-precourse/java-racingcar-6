package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public static void printResult(Map<String, Integer> carDistanceMap) {
        for (Map.Entry<String, Integer> carDistanceEntry : carDistanceMap.entrySet()) {
            // '-'를 carDistanceMap의 value 만큼 반복하여 새로운 문자열을 만드는 함수
            System.out.printf("%s : %s", carDistanceEntry.getKey(), "--");
        }
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();

        Map<String, Integer> carDistanceMap = carDistanceMap(carNames);

        System.out.println("시도할 회수는 몇회인가요?");

        Integer repeatCount = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");

        for (int i = 0; i < repeatCount; i++) {

            carDistanceMap = movingCar(carDistanceMap);

            // 시행 결과 출력
        }

        String winners = "sample_winners";

        System.out.printf("최종 우승자 : %s", winners);
    }
}
