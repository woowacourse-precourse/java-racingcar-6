package racingcar.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterCarNamesInputView extends InputView<String> {
    public static final Pattern CAR_NAME_PATTERN = Pattern.compile("^([a-zA-Z],?)+$");

    @Override
    public String input(Map<String, Object> model) {
        String replacedLine = Console.readLine().replaceAll(" ", "");
        isNullOrEmpty(replacedLine);
        hasValidCharacters(replacedLine);
        return replacedLine;
    }

    private void isNullOrEmpty(String s) {
        if (Objects.isNull(s) || Objects.equals(s.length(), 0)) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다");
        }
    }

    private void hasValidCharacters(String s) {
        if (!CAR_NAME_PATTERN.matcher(s).matches()) {
            throw new IllegalArgumentException("영문 이름을 작성해주세요.");
        }
    }
}
