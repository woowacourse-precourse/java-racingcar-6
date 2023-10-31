package racingcar;

public class Racer {
    private String name;

    public Racer(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null Input (racer)");
        }
        this.name = name;
    }
}
