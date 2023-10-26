package racingcar.domain;

public class Car {

    private String name;
    private Integer position;
    private static final Integer START_POSITION = 0;
    private static final Integer ONE_STEP = 1;
    private static final Integer CAN_GO_NUMBER = 4;


    private Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    private Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        //validateName(name);
        return new Car(name);
    }

    public void go() {
        Integer randomNumber = RandomNumberGenerator.generate();

        if (isAbleToGo(randomNumber)) {
            position += ONE_STEP;
        }
    }

    private static boolean isAbleToGo(Integer randomNumber) {
        return randomNumber >= CAN_GO_NUMBER;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

}
