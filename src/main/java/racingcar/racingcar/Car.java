package racingcar.racingcar;

import racingcar.playrule.RacingRule;

/**
 * @author 민경수
 * @description car
 * @since 2023.10.27
 **********************************************************************************************************************/
public class Car {

    private final RacingRule racingRule;
    private final String name;
    private Integer position;

    public Car(RacingRule racingRule, String name, Integer position) {
        this.racingRule = racingRule;
        this.name = name;
        this.position = position;
    }

    public void move() {
        if (racingRule.isMovable()) {
            position += 1;
        }
    }

    public String name() {
        return name;
    }

    public Integer position() {
        return position;
    }
}