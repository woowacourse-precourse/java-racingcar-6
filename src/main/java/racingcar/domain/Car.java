package racingcar.domain;

public class Car {

    private String name;
    private Integer position;
    private static final Integer START_POSITION = 0;


    private Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public static Car from(String name) {
        //validateName(name);
        return new Car(name);
    }
}
