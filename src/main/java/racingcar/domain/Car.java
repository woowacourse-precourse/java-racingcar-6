package racingcar.domain;

public class Car {

    private static final Integer START_POSITION = 0;
    private static final Integer ONE_STEP = 1;
    private static final Integer CAN_GO_NUMBER = 4;
    private static final Integer LIMIT_NAME_LENGTH = 5;

    private final String name;
    private Integer position;


    private Car(String name) {
        validate(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private void validate(String name) {
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR]이름 길이가 너무 깁니다.");
        }
    }

    public static Car from(final String name) {
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

    public Boolean isHere(final Integer position) {
        return this.position.equals(position);
    }

}
