package racingcar.domain;

public class RacingCar {
    public static String SYMBOL = "-";
    public static int MOVABLE_VALUE = 4;
    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int randomNumber) {
        if (canMove(randomNumber)) {
            this.distance++;
        }
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= MOVABLE_VALUE;
    }

    public String getDistanceGraph() {
        String visualizedDistance = SYMBOL.repeat(this.distance);
        return String.format("%s : %s", this.name, visualizedDistance);
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}
