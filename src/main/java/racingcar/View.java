package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    private static final String DELIMITER = ",";
    private static final String MESSAGE_WINNER_FORMAT = "최종 우승자 : %s";

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String read = Console.readLine();
        String[] names = getNames(read);
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

    public void printWinners(List<String> winners) {
        String names = String.join(DELIMITER, winners);
        System.out.println(String.format(MESSAGE_WINNER_FORMAT, names));
    }

    private String[] getNames(String s) {
        String[] names = s.split(DELIMITER);
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].strip();
        }
        return names;
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
            if (name.length() > 5 || name.length() == 0) {
                throw new IllegalArgumentException("1자 이상 5자 이하만 입력할 수 있습니다.");
            }
        }
    }
}
