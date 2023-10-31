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



}