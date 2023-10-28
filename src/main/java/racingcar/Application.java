package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class Application {
    private static final int INIT_DISTANCE = 0;

    public static void main(String[] args) {
        // HashMap의 순서를 보장하기 위해 LinkedHashMap 사용
        Map<String, Integer> memberStates = new LinkedHashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String memberInput = Console.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(memberInput, ",");
        while (stringTokenizer.hasMoreTokens()) {
            String name = stringTokenizer.nextToken();
            memberStates.put(name, INIT_DISTANCE);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String tryInput = Console.readLine();
        int tryCount = Integer.parseInt(tryInput);
    }
}
