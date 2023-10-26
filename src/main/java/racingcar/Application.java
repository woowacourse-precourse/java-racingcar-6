package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String str = Console.readLine();
        List<String> carNames = new ArrayList<>(Arrays.asList(str.split(",")));

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String carName : carNames) map.put(carName, 0);

        System.out.println("시도할 회수는 몇회인가요?");
        int inputCount = Integer.parseInt(Console.readLine());

        race(inputCount, map);
    }

    private static void race(Integer inputCount, LinkedHashMap<String, Integer> map) {
        for (int i=0; i<inputCount; ++i) {
            System.out.println("실행 결과");
            for (HashMap.Entry<String, Integer> e : map.entrySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                String s = e.getKey() + " : ";
                int cnt = e.getValue();
                if (randomNumber >= 4) map.put(e.getKey(), ++cnt);
                for (int j=0; j<cnt; ++j) s += "-";
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
