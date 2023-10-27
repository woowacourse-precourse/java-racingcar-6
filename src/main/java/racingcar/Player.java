package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String LONG_INPUT_EXCEPTION = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String IS_DIGIT_EXCEPTION = "숫자는 입력할 수 없습니다.";
    private static final String CONTAIN_BLANK_EXCEPTION = "공백은 입력할 수 없습니다.";
    private static final int MAX_INPUT_LENGTH = 5;
    private static List<String> carList;
    private static int attempts;

    static void inputCarName() {
        System.out.println(INPUT_CAR_MESSAGE);
        carList = Arrays.asList(readLine().split(","));
        validateInput(carList);
    }

    static void validateInput(List<String> list) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher;
        for (String s : list) {
            matcher = pattern.matcher(s);
            if (s.length() > MAX_INPUT_LENGTH) {
                throw new IllegalArgumentException(LONG_INPUT_EXCEPTION);
            }
            if (matcher.find()) {
                throw new IllegalArgumentException(IS_DIGIT_EXCEPTION);
            }
            if (s.contains(" ")) {
                throw new IllegalArgumentException(CONTAIN_BLANK_EXCEPTION);
            }
        }
    }

    static void inputAttemptsCount() {
        System.out.println(INPUT_ATTEMPT_MESSAGE);
        attempts = Integer.parseInt(readLine());
    }

    static List<String> getCarList() {
        return carList;
    }

    static int getAttempts() {
        return attempts;
    }
}