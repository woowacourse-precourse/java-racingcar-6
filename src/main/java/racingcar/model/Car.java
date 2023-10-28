package racingcar.model;

public class Car {
    private String carName;
    private Integer moveDistance;

    public Car(String inputName, Integer inputScore) {
        this.carName = inputName;
        this.moveDistance = inputScore;
    }

    public void printcar() {
        System.out.println(this.carName.trim() + "의 점수" + this.moveDistance);
    }
}
