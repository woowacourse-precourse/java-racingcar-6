package racingcar;

public class RacingCar {
    private String name;
    private int distance = 0;

    public RacingCar(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance(){
        return distance;
    }

    public void distanceFoward(){
        distance++;
    }

    public void checkNameLength(String name){
        if(name.length() > 5){

            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
