package racingcar;

import java.util.List;

public class ExceptionHandler {

    public void isAttemptException(String attempt) {
        if (Validation.isEmpty(attempt)) {
            throw new IllegalArgumentException("시도 횟수가 빈 문자열입니다.");
        }

        if (!Validation.isNum(attempt)) {
            throw new IllegalArgumentException("시도 횟수가 숫자가 아닙니다.");
        }

        if (Validation.isBlank(attempt)) {
            throw new IllegalArgumentException("시도 횟수가 공백입니다.");
        }

        if (Validation.isBlankContain(attempt)) {
            throw new IllegalArgumentException("시도 횟수가 공백을 포함합니다.");
        }

        if (Validation.isNegative(Integer.parseInt(attempt))) {
            throw new IllegalArgumentException("시도 횟수가 0보다 작습니다.");
        }
    }

    public void isCarNamePlainTextException(String str) {
        if (Validation.isEmpty(str)) {
            throw new IllegalArgumentException("자동차 이름이 빈 문자열입니다.");
        }

        if (Validation.isBlank(str)) {
            throw new IllegalArgumentException("자동차 이름이 공백입니다.");
        }

        if (Validation.isBlankContain(str)) {
            throw new IllegalArgumentException("자동차 이름이 공백을 포함합니다.");
        }
    }

    public void isMembersException(List<String> members) {
        if (Validation.isEmpty(members)) {
            throw new IllegalArgumentException("자동차 이름이 빈 문자열입니다.");
        }

        for (int i = 0; i < members.size(); i++) {
            if (Validation.isEmpty(members.get(i))) {
                throw new IllegalArgumentException("자동차 이름이 빈 문자열입니다.");
            }
        }

        if (Validation.isBlank(members)) {
            throw new IllegalArgumentException("자동차 이름이 공백입니다.");
        }

        if (Validation.isOverFiveWord(members)) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과합니다.");
        }

        for (int i = 0; i < members.size(); i++) {
            if (Validation.isDuplicates(members, members.get(i), i)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }
        }
    }

    public void isMembersException(List<String> members, int inputSize) {
        if (!Validation.isCorrectComma(members, inputSize)) {
            throw new IllegalArgumentException("쉼표(,)는 자동차 이름 사이에 하나씩 들어가야합니다.");
        }
    }
}
