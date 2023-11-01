package racingcar;

public class RacingCar {
    private final String name;
    private int moved;
    StringBuilder distance = new StringBuilder();

    public RacingCar(String name, int moved) {
        this.name = name;
        this.moved = moved;
    }

    public String getName() {
        return name;
    }

    public int getMoved(){
        return moved;
    }

    public void simulate(int randNum) {
        if (randNum >= 4) {
            this.distance.append("-");
            this.moved += 1;
        }

        System.out.println(name + " : " + distance);
    }
}
