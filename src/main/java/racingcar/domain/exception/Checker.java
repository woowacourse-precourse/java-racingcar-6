package racingcar.domain.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public static String[] hasCommasWithoutSurroundingValues(String linUpStr) {
        // 정규 표현식 패턴: 전후에 아무런 값이 없는 쉼표
        Pattern pattern = Pattern.compile("^,|,$|[^,],,[^,]");
        Matcher matcher = pattern.matcher(linUpStr);

        // 매칭 결과 확인
        if (matcher.find()) throw new IllegalArgumentException("쉼표(,) 전후에 아무런 값이 없는 경우가 있습니다.");
        else return linUpStr.split(",");
    }

    public static void lenCheck(String[] lineUpArr) {
        for (String name : lineUpArr) {
            if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public static int typeCheck(String val) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }
}
