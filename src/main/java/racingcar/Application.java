package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();

        Map<String, Integer> carMap = Stream.of(carNames.split(","))
                .collect(Collectors.toMap(carName -> carName, score -> 0));
        //System.out.println(carMap);

        System.out.println("시도할 회수는 몇회인가요?");

        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
            if (tryCount < 1) {
                throw new IllegalArgumentException("시도할 회수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수로 숫자를 입력해주세요.");
        }

        for (int i = 0; i < tryCount; i++) {
            for (String carName : carMap.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                //System.out.println("randomNumber : " + randomNumber);
                if (randomNumber >= 4) {
                    carMap.put(carName, carMap.get(carName) + 1);
                }
                System.out.println(carName + " : " + "-".repeat(carMap.get(carName)));
            }
            System.out.println();
        }

        int maxScore = Collections.max(carMap.values());

        List<String> winners = new ArrayList<>();
        for (String carName : carMap.keySet()) {
            if (carMap.get(carName) == maxScore) {
                winners.add(carName);
            }
        }
        
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);

    }
}