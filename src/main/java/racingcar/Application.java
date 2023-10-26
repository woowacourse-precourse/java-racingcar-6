package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String str = Console.readLine();
        List<String> carNames = new ArrayList<>(Arrays.asList(str.split(",")));
        checkException(carNames);

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String carName : carNames) map.put(carName, 0);

        System.out.println("시도할 회수는 몇회인가요?");
        int inputCount = Integer.parseInt(Console.readLine());

        race(inputCount, map);
        System.out.println(getAnswer(map));
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

    public static String getAnswer(LinkedHashMap<String, Integer> map) {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (HashMap.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                winners.clear();
                winners.add(e.getKey());
            } else if (e.getValue() == max) {
                winners.add(e.getKey());
            }
        }

        String ans = "최종 우승자 : ";
        for (String winner : winners) {
            ans += winner + ", ";
        }
        ans = ans.substring(0, ans.length()-2);
        return ans;
    }

    public static void checkException(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
