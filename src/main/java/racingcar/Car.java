package racingcar;

public class Car {
    private final String name;
    private int score;
    
    public String getName() { return this.name; }

    public int getScore() {
        return this.score;
    }
    
    public void addScore() {
        this.score += 1;
    }

    public Car(String name) {
        if (!isValid(name)) {
            throw new IllegalArgumentException("Car name invalid: " + name);
        }
        this.name = name;
        this.score = 0;
    }
    
    private boolean isValid(String input) {
        return input.length() <= 5 && !input.isEmpty();
    }
}
