package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] split = carNames.split(",");

        for (String s : split) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름의 길이는 5를 초과할 수 없습니다.");
            }
        }
        System.out.println("시도할 횟수는 몇 번인가요?");
        String tryCount = Console.readLine();
        if (!isNumberic(tryCount)) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력할 수 없습니다.");
        }

        String forward = "-";

        int moving = 0;

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            strings.add("");
        }

        System.out.println("실행결과");

        for (int i = 0; i < Integer.parseInt(tryCount); i++) {
            for (int j = 0; j < split.length; j++) {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= 4) {
                    moving++;
                }
                System.out.print(split[j] + " : ");
                if (moving != 0) {
                    strings.set(j, strings.get(j) + forward);
                }
                System.out.println(strings.get(j));
                moving = 0;
            }
            System.out.println();
        }

        int max = 0;

        // 우승자 출력
        List<String> winner = new ArrayList<>();

        for (String string : strings) {
            if (max < string.length()) {
                max = string.length();
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() == max) {
                winner.add(split[i]);
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", winner));
    }

    private static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

}
