package racingcar.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition() {
        this.position = this.position + 1;
        System.out.println("position = " + position);
    }

    public void setPosition(int num) {
        this.position = num;
    }

    public void carMove(int randomNumber) {
        if (randomNumber >= 4) {
            setPosition();
        }
    }
}
