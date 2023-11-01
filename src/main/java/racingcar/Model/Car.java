package racingcar.Model;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("Invalid car name");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    // 무작위 수를 받아 4 이상이면 전진
    public void move(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
