package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Print {

    public static void PrintRacing(Map<String, Integer> carsList) {

        // 저장된 문자열 "-" 출력
        for (Map.Entry<String, Integer> entry : carsList.entrySet()) {
            String valueToPrint;

            if (entry.getValue() > 0) {
                valueToPrint = "-".repeat(entry.getValue());
            } else {
                valueToPrint = "";
            }
            System.out.println(entry.getKey() + " : " + valueToPrint);
        }
        System.out.println("");
    }

    public static void PrintWinner(List<String> mostDashesCar) {
        // 최종적으로 가장 많은 "-" 값을 가진 key(자동차) 출력
        if (!mostDashesCar.isEmpty()) {
            String winnerCars = String.join(", ", mostDashesCar);
            System.out.println("최종 우승자 : " + winnerCars);
        } else {
            System.out.println("우승자는 없습니다.");
        }
    }

}