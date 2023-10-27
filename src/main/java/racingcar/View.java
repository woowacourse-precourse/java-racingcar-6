package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    private final String DELIMITER = ",";

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String read = Console.readLine();
        String[] names = read.split(DELIMITER);
        validateNameLength(names);
        return names;
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String read = Console.readLine();
        System.out.println();
        validateIsNumber(read);
        return Integer.parseInt(read);
    }

    public void printCurrentResult(List<String> results) {
        System.out.println("실행 결과");
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    private void validateIsNumber(String s) {
        try {
            Integer.parseInt(s);
        }catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    private void validateNameLength(String[] names) {
        for(String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이하만 입력할 수 있습니다.");
            }
        }
    }
}
