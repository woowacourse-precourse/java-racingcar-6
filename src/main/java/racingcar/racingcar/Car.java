package racingcar.racingcar;

import racingcar.playrule.RacingRule;

/**
 * @author 민경수
 * @description car
 * @since 2023.10.27
 **********************************************************************************************************************/
public class Car {

    private RacingRule racingRule;
    private final String name;
    private Integer position;

    public Car(RacingRule racingRule, String name, Integer position) {
        validateNameLength(name);

        this.racingRule = racingRule;
        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 공백 포함 5글자를 초과할 수 없습니다. 이름을 확인해주세요. 입력한 이름 : " + name);
        }
    }

    public void move() {
        if (racingRule.isMovable()) {
            position += 1;
        }
    }

    public RacingRule racingRule() {
        return racingRule;
    }

    public String name() {
        return name;
    }

    public Integer position() {
        return position;
    }
}