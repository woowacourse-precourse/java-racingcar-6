package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public void forward() {
        position++;
    }
    public String viewProgress() {
        String result = "";
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        return result;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
