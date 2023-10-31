package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        LinkedHashMap<String, StringBuilder> racers = requestRacers();
        int num = requestNum();

        System.out.println("\n실행 결과");
        for (; num > 0; num--) {
            race(racers);
        }
        judge(racers);
    }

    public static LinkedHashMap<String, StringBuilder> requestRacers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = readLine().split(",");

        if (!isInputValid(names)) throw new IllegalArgumentException();

        return Stream.of(names).collect(
                Collectors.toMap(name -> name, value -> new StringBuilder(), (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static boolean isInputValid(String[] names) {
        return names.length >= 2 && Stream.of(names).allMatch(name -> name.length() <= 5);
    }

    public static int requestNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();

        if (!input.matches("^[1-9]\\d*$")) throw new IllegalArgumentException();

        return Integer.parseInt(input);
    }

    public static void race(LinkedHashMap<String, StringBuilder> racers) {
        for (String racer : racers.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                racers.get(racer).append("-");
            }
            System.out.println(racer + " : " + racers.get(racer));
        }
        System.out.println("");
    }

    public static void judge(LinkedHashMap<String, StringBuilder> racers) {
        int maxLength = racers.values()
                .stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);

        String winners = racers.entrySet()
                .stream()
                .filter(racer -> racer.getValue().length() == maxLength)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winners.toString());
    }
}
