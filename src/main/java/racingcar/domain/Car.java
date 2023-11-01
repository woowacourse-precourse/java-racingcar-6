package racingcar.domain;

public class Car implements Comparable{
    private String name;
    private Integer position;

    public Car(String name) {
        assertValidName(name);

        this.name = name;
        this.position = 0;
    }

    public Car(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    private void assertValidName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Invalid Name");
        }
    }

    public void move(MoveCarType moveCarType) {
        position += moveCarType.getMovingPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


    @Override
    public int compareTo(Object target) {
        if (!(target instanceof Car)) {
            throw new IllegalArgumentException("[Car] 올바른 비교 대상이 아닙니다.");
        }
        return this.position.compareTo(((Car) target).getPosition());
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(Math.max(0, this.position));
    }


}
