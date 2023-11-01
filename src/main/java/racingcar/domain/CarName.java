package racingcar.domain;

import racingcar.util.StringUtil;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (StringUtil.isBlank(name)) {
            throw new IllegalArgumentException("공백으로만 이루어진 차 입력은 허용되지 않습니다.");
        }
        if (StringUtil.isLengthOverFive(name)) {
            throw new IllegalArgumentException("차 이름의 길이는 5 이하여야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
