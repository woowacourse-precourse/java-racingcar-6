package racingcar.model;

/**
 * 차에 대한 정보를 갖는다.
 */
public class Car {

    private final Name name;
    
    /**
     * 자동차가 전진한 횟수
     */
    private int advance = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void increaseAdvance() {
        this.advance++;
    }

    public String getName() {
        return name.getName();
    }

    public int getAdvance() {
        return advance;
    }
}
