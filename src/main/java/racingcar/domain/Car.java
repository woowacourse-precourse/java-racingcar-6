package racingcar.domain;

public class Car {

    private String name = "";
    private int progress;

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        progress++;
    }

    public String viewProgress() {
        String result = "";
        for (int i=0; i<progress; i++) {
            result += "-";
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }
}
