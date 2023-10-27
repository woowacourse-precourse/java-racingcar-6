package racingcar.domain;

public class Car {
    private final String name;
    private final int count;

    public Car(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name).append(" : ");
        for (int i = 0; i < count; i++)
            builder.append("-");
        return builder.toString();
    }
}
