package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String SINGLE_INPUT_EXCEPTION = "최소 1개 이상의 이름을 입력하세요.";
    private static final String DUPLICATE_INPUT_EXCEPTION = "중복된 이름은 입력할 수 없습니다.";
    private static final String LONG_INPUT_EXCEPTION = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String IS_DIGIT_EXCEPTION = "숫자는 입력할 수 없습니다.";
    private static final String CONTAIN_BLANK_EXCEPTION = "공백은 입력할 수 없습니다.";
    private static final int MAX_INPUT_LENGTH = 5;
    private static String carNames;
    private static List<String> carList;
    private static int attempts;

    static void inputCarName() {
        System.out.println(INPUT_CAR_MESSAGE);
        carNames = readLine();
    }

    static void makeCarList(String name) {
        carList = Arrays.asList(name.split(","));
    }

    static void validateInput(List<String> list) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher;
        Set<String> set = new HashSet<>(list);
        if (list.size() == 1) {
            throw new IllegalArgumentException(SINGLE_INPUT_EXCEPTION);
        }
        if (set.size() != list.size()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_EXCEPTION);
        }
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

    public static String getCarNames() {
        return carNames;
    }

    static List<String> getCarList() {
        return carList;
    }

    static int getAttempts() {
        return attempts;
    }
}