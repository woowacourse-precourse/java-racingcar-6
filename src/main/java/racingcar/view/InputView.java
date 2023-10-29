package racingcar.view;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.HashSet;

public class InputView {
    public static List<String> inputCarName() {
        String carNames = Console.readLine();
        List<String> names = Arrays.stream(carNames.split(","))
                .map(String::trim) // 공백 제거
                .peek(InputView::validateName) // 이름 유효성 검사
                .collect(Collectors.toList());
        validateUniqueNames(names);
        return names;
    }

    private static void validateName(String name) {         // 자동차 이름 검증
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름을 정확히 입력해주세요.");
        }
    }

    private static void validateUniqueNames(List<String> names) {       // 자동차 이름 중복 제거
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() < names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static int inputPlayRound() {
        String playRound = Console.readLine();
        try {
            int count = Integer.parseInt(playRound);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수로 유효한 숫자를 입력해주세요.");
        }
    }
}
