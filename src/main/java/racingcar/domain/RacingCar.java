package racingcar.domain;

public class RacingCar {
    private String name;
    private Integer move;
    public RacingCar(String name, Integer move){
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

}
