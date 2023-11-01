package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.UserInputData;
import racingcar.view.Description;
import racingcar.view.View;

public class Input {

    /**
     * 경주 게임 시작을 위한 입력 받기
     *
     * @return 게임 시작을 위한 기초 데이터
     */
    public static UserInputData inputGameInfo() {
        UserInputData answer = new UserInputData();

        answer.carName = inputCarName();
        answer.loopCount = inputTryCount();

        return answer;
    }

    /**
     * 자동차 이름 입력
     *
     * @return 입력받은 자동차 이름 리스트
     */
    private static List<String> inputCarName() {
        final String SEPARATOR_CHARACTER = ",";
        final int LENGTH_LIMIT = 5;
        List<String> answer;
        View.show(Description.INPUT_CARNAME);
        String str = Console.readLine();
        answer = Arrays.asList(str.split(SEPARATOR_CHARACTER));

        var count = answer.stream()
                .filter(name -> name.length() > LENGTH_LIMIT)
                .count();

        if (count != 0L) {
            throwArgumentException("자동차 명은 최대 5까지만 허용됩니다.");
        }

        return answer;
    }

    /**
     * 반복 횟수 입력
     *
     * @return 반복 횟수
     */
    private static int inputTryCount() {
        int answer;
        final int MINIMUM_TRY_COUNT = 1;
        final String NUMERIC_PATTERN = "^[\\d]*";
        View.show(Description.INPUT_TRY_COUNT);
        String str = Console.readLine();

        if (!str.matches(NUMERIC_PATTERN)) {
            throwArgumentException("시도횟수는 아라비아 숫자 0-9로 이루어진 문자열로 입력해야합니다.");
        }
        answer = Integer.parseInt(str);

        if (answer < MINIMUM_TRY_COUNT) {
            throwArgumentException("시도횟수는 최소 1회부터 시작합니다.");
        }

        return answer;
    }

    private static void throwArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

}
