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

    private boolean isRunnable(){
        int number = Util.getRandomSingleDigit();
        return Util.getBooleanByNumber(number);
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    private void plusStep(int number) {
        this.step += number;
    }
}
