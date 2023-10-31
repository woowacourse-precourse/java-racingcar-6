package racingcar;

import camp.nextstep.edu.missionutils.Console;

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

    }
}