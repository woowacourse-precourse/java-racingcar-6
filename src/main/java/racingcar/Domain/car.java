package racingcar.Domain;


public class car {
    private static final Integer POSITION_INCREMENT = 1;
    private static final Integer POSITION_INIT = 0;
    private final String name;
    private Integer position;

    private car (String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static car of (String name) {
        return new car(name, POSITION_INIT);
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
