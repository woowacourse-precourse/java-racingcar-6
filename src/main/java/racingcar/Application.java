package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> userMap = userCar();

    }

    public static Map<String, Integer> userCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = readLine();

        StringTokenizer st = new StringTokenizer(inputString, ",");
        Map<String, Integer> map = new LinkedHashMap<>();
        while (st.hasMoreTokens()) {
            map.put(st.nextToken(), 0);
        }

        return map;
    }
}
