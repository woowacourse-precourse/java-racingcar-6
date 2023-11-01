package racingcar.domain;

/**
 * 자동차 정보를 담는 클래스
 */
public class Car implements Unchangeable {
    private String name;
    private int movement;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int movement) {
        this.name = name;
        this.movement = movement;
    }

    public void race(int randomNum) {
        if (randomNum >= 4) {
            movement++;
        }
    }

    /**
     * 경주 결과를 만듬.
     *
     * @return ex) 이름 : ---
     */
    @Override
    public String toString() {
        return name + " : " + showMovement();
    }

    public String showMovement() {
        StringBuilder score = new StringBuilder();
        for (int i = 0; i < movement; i++) {
            score.append("-");
        }
        return score.toString();
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }
}
