package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

    private static final Pattern ALPHABET_AND_HANGUL_PATTERN = Pattern.compile("^[a-zA-Z가-힣]+$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?[0-9]+$");

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> car = new ArrayList<>();
        Long carNameSize;
        int tryCount;
        List<Integer> position = new ArrayList<>();
        int maxPosition;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        carNameSize = Arrays.stream(input.split(","))
                .distinct()
                .count();

        car = Arrays.asList(input.split(","));

        for (String name : car) {
            if (!ALPHABET_AND_HANGUL_PATTERN.matcher(name).matches()) {
                throw new IllegalArgumentException("차 이름은 영어 또는 한글만 가능");
            }
        }

        if (car.size() != carNameSize) {
            throw new IllegalArgumentException("중복 이름 불가");
        }

        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("시도할 회수는 숫자만 가능");
        }

        tryCount = Integer.parseInt(input);

        if (tryCount <= 0) {
            throw new IllegalArgumentException("1 이상의 양수만 입력 가능.");
        }

        for (int i = 0; i < car.size(); i++) {
            position.add(0);
        }

        System.out.println("실행결과");

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < car.size(); j++) {
                int forwardRandomValue = Randoms.pickNumberInRange(0, 9);
                if (forwardRandomValue >= 4) {
                    position.set(j, position.get(j) + 1);
                }
            }

            for (int j = 0; j < car.size(); j++) {
                System.out.print(car.get(j) + " : ");
                for (int k = 0; k < position.get(j); k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        List<String> winners = new ArrayList<>();
        maxPosition = position.stream().mapToInt(v -> v).max().orElseThrow();
        for (int i = 0; i < car.size(); i++) {
            if (position.get(i) == maxPosition) {
                winners.add(car.get(i));
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
