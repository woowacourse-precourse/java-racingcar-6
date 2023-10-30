package racingcarv2;

import java.util.Arrays;
import java.util.Objects;

public class Name {
    private static final String SEPARATOR_COMMA = ",";
    // 중복 여부 확인 그리고 5글자 이하인지 확인
    // regex, null empty는 뷰에서 처리
    private final String nameValue;

    public Name(String name) {
        validateName(name.split(SEPARATOR_COMMA));
        this.nameValue = name;
    }

    private void validateName(String[] names) {
        validateLength(names);
        validateDuplication(names);
    }

    private void validateLength(String[] names) {
        Arrays.stream(names)
                .forEach(name -> isOutOfRange(name));
    }

    private void isOutOfRange(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("문자열의 길이가 범위에서 벗어났습니다");
        }
    }

    private void validateDuplication(String[] names) {
        if (!Objects.equals(Arrays.stream(names).count(), Arrays.stream(names).distinct().count())) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(getNameValue(), name1.getNameValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameValue());
    }

    public String getNameValue() {
        return nameValue;
    }
}
