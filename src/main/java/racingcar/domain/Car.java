package racingcar.domain;

public class Car {

    public static final int MOVE_BOUNDARY = 4;
    private final Generator generator;
    private int location;
    private final String name;

    public Car(String name, Generator generator) {
        validateName(name);
        this.name=name;
        location = 0;
        this.generator = generator;
    }

    public void move() {
        if (isMove()) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    private boolean isMove() {
        return MOVE_BOUNDARY <= generator.generate();
    }

    private void validateName(String name) {
        if(name.length()>5){
            throw new IllegalArgumentException("이름의 길이를 5이하로 해주세요");
        }
    }
}
