package racingcar.Domain;


public class Car {
    private static final Integer POSITION_INCREMENT = 1;
    private static final Integer POSITION_INIT = 0;
    private final String name;
    private Integer position;

    private Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static Car of (String name) {
        return new Car(name, POSITION_INIT);
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
