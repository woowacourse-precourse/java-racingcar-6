package racingcar.model;

public class Car {
    String name;
    int move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public void moveCar() {
        this.move++;
    }

    public String getMoveMark() {
        return "-".repeat(this.move);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.name);
        sb.append(" : ");
        sb.append(getMoveMark());
        return sb.toString();
    }
}
