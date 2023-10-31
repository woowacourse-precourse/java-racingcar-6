package racingcar.model;

public class CarComponent {
    private String name;
    private int distance;

    public CarComponent(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void addDistance() {
        if(CarService.getInstance().carMoveJudgment()) {
            this.distance += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
