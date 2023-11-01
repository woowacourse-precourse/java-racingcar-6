package racingcar;

public class RacingCar {
    private String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public void move(int distance) {
        position += distance;
    }

    public String getName(){
        return name;
    }

}
