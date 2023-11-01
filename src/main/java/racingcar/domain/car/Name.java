package racingcar.domain.car;

import exception.WrongNameException;

public record Name(String value) {
    private static final int NAME_LENGTH = 5;

    public Name {
        valid(value);
    }

    private void valid(String name) {
        if (isLengthOver(name) || isEmpty(name)) {
            throw new WrongNameException("이름을 확인해주세요.");
        }
    }

    private boolean isLengthOver(String name) {
        return name.length() > NAME_LENGTH;
    }

    private boolean isEmpty(String name) {
        return name.isEmpty();
    }
}
