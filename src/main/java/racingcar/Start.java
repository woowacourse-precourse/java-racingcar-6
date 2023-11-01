package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;

public class Start {
    public ArrayList<String> name() {
        System.out.println("경주할 자동차 이름을 입력하세요,(이름은 쉼표(,)기준으로 구분)");
        String[] raw = Console.readLine().split(",");
        ArrayList<String> names = new ArrayList<>(Arrays.asList(raw));

        for (String name : names) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException("잘못된 이름입니다.");
            }
        }
        return names;
    }

    public int times() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String raw = Console.readLine();

        try {
            int result = Integer.parseInt(raw);
            if (result < 0) {
                throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
            }
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
}
