package racingcar.model.vo;

import java.util.Objects;

public class Attempt {

    private Integer count;

    private Attempt(String count) {
        validate(count);
        this.count = Integer.parseInt(count);
    }

    public static Attempt from(String count) {
        return new Attempt(count);
    }

    private void validate(String attempt) {
        isBlank(attempt);
        isNumeric(attempt);
    }

    private void isBlank(String attempt) {
        if (attempt.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    private void isNumeric(String attempt) {
        if (!attempt.matches("\\d")) {
            throw new IllegalArgumentException("숫자 이외에 입력할 수 없습니다.");
        }
    }

    public Integer getIterateCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attempt attempt = (Attempt) o;
        return Objects.equals(count, attempt.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}

