package racingcar;

public class RacingCarInformation {
    private String name;
    private int position;

    private RacingCarInformation(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RacingCarInformation of(String name, int position) {
        return new RacingCarInformation(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
