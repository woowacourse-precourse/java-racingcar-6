package racingcar;

public class Car {
    private final String name;
    private int step;

    public Car(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public void run() {
        if (isRunnable()) {
            plusStep(1);
        }
    }

    private void plusStep(int number) {
        this.step += number;
    }

    private boolean isRunnable(){
        int number = Util.getRandomSingleDigit();
        return Util.getBooleanByNumber(number);
    }

    String getName() {
        return name;
    }

    int getStep() {
        return step;
    }
}
