package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

public class Car {
    public static final int MAX_LENGTH = 5;

    private final String name;
    private int poisiton = 0;

    public Car(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }
        this.name = name.trim();
    }

    public int getPoisiton() {
        return poisiton;
    }

    public String getName() {
        return name;
    }

    public void move() {
        this.poisiton++;
    }
}