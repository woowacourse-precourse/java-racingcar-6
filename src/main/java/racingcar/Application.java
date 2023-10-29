package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        HashMap<String, StringBuilder> racers = requestRacers();
        int num = requestNum();

        System.out.println("\n실행 결과");
        for (; num > 0; num--) {
            race(racers);
        }
    }

    public static HashMap<String, StringBuilder> requestRacers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = readLine().split(",");

        if (input.length < 2) throw new IllegalArgumentException();

        Map<String, StringBuilder> racers = Stream.of(input)
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException();
                    }
                })
                .collect(Collectors.toMap(name -> name, name -> new StringBuilder()));

        return new HashMap<>(racers);
    }

    public static int requestNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();

        if (!input.matches("^[1-9]\\d*$")) throw new IllegalArgumentException();
        return Integer.parseInt(input);
    }

    public static void race(HashMap<String, StringBuilder> racers) {

        for (String racer : racers.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {racers.get(racer).append("-");}
            System.out.println(racer + " : " + racers.get(racer));
        }
        System.out.println("");
    }
}
