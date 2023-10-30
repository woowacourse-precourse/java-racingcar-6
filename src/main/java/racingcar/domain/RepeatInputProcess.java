package racingcar.domain;

public class RepeatInputProcess {
    public int process(String input) {
        int repeat = 0;

        try {
            repeat = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자입니다.");
        }

        return repeat;
    }
}
