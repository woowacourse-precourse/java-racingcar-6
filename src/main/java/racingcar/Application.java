package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        HashMap<String, Integer> score = new HashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] name = names.split(",");
        for (String n : name) {
            if (n.length() > 5) throw new IllegalArgumentException();
            score.put(n, 0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int num;
        try {
            num = Integer.parseInt(Console.readLine());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }

        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            for (String n : name) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                if (randomNum >= 4) score.put(n, score.get(n) + 1);
                System.out.println(n + " : " + "-".repeat(score.get(n)));
            }
            System.out.println();
        }

        List<String> keySet = new ArrayList<>(score.keySet());
        keySet.sort((o1, o2) -> score.get(o2).compareTo(score.get(o1)));

        Integer maxScore = score.get(keySet.get(0));
        String result = score.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxScore))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining("," + " "));

        System.out.println("최종 우승자" + " : " + result);

    }
}