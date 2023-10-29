package racingcar.race;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public void plusPosition() {
        position++;
    }
    public String getName() {
        return name;
    }
    public String addDash() {
        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < position; i++) {
            dash.append("-");
        }
        return dash.toString();
    }
}
