package racingcar.domain;

import static racingcar.util.ExceptionMessage.INVALID_NICKNAME;
import static racingcar.util.ExceptionMessage.INVALID_NICKNAME_RANGE;

import java.util.Objects;
import racingcar.util.StringUtils;

public class NickName {
    private final String nickName;

    public NickName(String nickName) {
        this.nickName = validateName(nickName);
    }

    private String validateName(String nickName) {
        if (StringUtils.isBlank(nickName)) {
            throw new IllegalArgumentException(INVALID_NICKNAME.getMessage());
        }
        if (nickName.length() > 5) {
            throw new IllegalArgumentException(INVALID_NICKNAME_RANGE.getMessage());
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
