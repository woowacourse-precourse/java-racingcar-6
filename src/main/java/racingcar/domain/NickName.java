package racingcar.domain;

import java.util.Objects;
import racingcar.util.StringUtils;

public class NickName {
    private final String nickName;

    public NickName(String nickName) {
        this.nickName = validateName(nickName);

    }

    private String validateName(String nickName) {
        if (StringUtils.isBlank(nickName)) {
            throw new IllegalArgumentException("자동차 이름에 공백은 입력할 수 없습니다.");
        }
        if (nickName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5글자까지 가능합니다.");
        }
        return nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NickName nickName1 = (NickName) o;
        return Objects.equals(nickName, nickName1.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName);
    }

    @Override
    public String toString() {
        return nickName.toString();
    }
}
