package racingcar.model;

// position이 final이 아니라 Record 사용 불가
public final class Car {
    private final String name;
    private int position;

    /**
     * @param name     자동차 이름
     * @param position 자동차 전진 위치
     */
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void increasePosition() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
