package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {

        HashMap<String, Integer> score = new HashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] name = names.split(",");

        try {
            Arrays.stream(name)
                    .filter(n -> n.length() <= 5)
                    .forEach(n -> score.put(n, 0));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 회수는 몇회인가요?");
        Integer num = Integer.valueOf(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            for (String n : name) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                if (randomNum >= 4) score.put(n, score.get(n) + 1);
                System.out.println(n + " : " + "-".repeat(score.get(n)));
            }
            System.out.println();
        }

    }
}