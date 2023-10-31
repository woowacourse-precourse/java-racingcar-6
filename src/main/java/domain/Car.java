package domain;

public class Car {
    private final String name;
    private int raceCount;

    public Car(String name) {
        CheckName(name);
        this.name = name;
        this.raceCount = 0;
    }

    public void CheckName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자까지만 허용합니다.");
        }

        if (name.equals(" ")) {
            throw new IllegalArgumentException("공백의 이름은 허용하지 않습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
