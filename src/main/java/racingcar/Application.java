package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        Map<String, String> carNameHashMap = new LinkedHashMap<>();
        String[] parts = carName.split(",");
        for (String part : parts) {
            if (part.length() > 5) {
                throw new IllegalArgumentException();
            }
            carNameHashMap.put(part, "");
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        String attemptsString = Console.readLine();
        int attemptsNumber = Integer.parseInt(attemptsString);
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < attemptsNumber; i++) {
            for (Entry<String, String> element : carNameHashMap.entrySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                String move;
                if (randomNumber >= 4) {
                    move = "-";
                } else {
                    move = "";
                }
                String originalValue = element.getValue();
                String newValue = originalValue + move;
                carNameHashMap.put(element.getKey(), newValue);
                System.out.println(element.getKey() + " : " + element.getValue());
            }
            System.out.println("");
        }

        int largestMove = 0;
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            int moveLength = element.getValue().length();
            if (moveLength > largestMove) {
                largestMove = moveLength;
            }
        }

        List<String> winnerList = new ArrayList<>();
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            int moveLength = element.getValue().length();
            if (moveLength == largestMove) {
                winnerList.add(element.getKey());
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (winnerList.size() > 1) {
                System.out.print(", ");
            }
        }
    }
}
