package racingcar;

public class RacingCar {

    private String name;

    private int count = 0;

    public void moveOneBlock() {
        this.count += 1;
    }

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
    }

    public void printCurrentResult() {
        System.out.println(this.getName() + " : " +
                "-".repeat(this.getCount()));
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

}
