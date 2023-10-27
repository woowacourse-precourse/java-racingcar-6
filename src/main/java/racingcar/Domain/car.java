package racingcar.Domain;

import java.util.Map;

public class car {
    private static final Integer POSITION_INCREMENT = 1;
    private String name;
    private Integer position;

    private car (String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static car of (String name, Integer position) {
        return new car(name, position);
    }

    public String findName () {
        return this.name;
    }

    public Integer findPosition () {
        return this.position;
    }

    public void updatePosition () {
        this.position += POSITION_INCREMENT;
    }

}
