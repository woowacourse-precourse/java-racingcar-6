package racingcar.component.domain;

public class Car implements Comparable<Car>{
    private String name;
    private String progress;

    public Car (String name) {
        this.name = name;
        this.progress = "";
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }

    public void go() {
        this.progress += "-";
    }

    @Override
    public int compareTo(Car o) {
        return o.progress.length() - this.progress.length();
    }
}
