package racingcar;

public class Car {

    private static final String FIELD = "FIELD";
    private String carName;
    private String currentLocation;
    private int score;

    Car(String carName, String field){
        this.carName = carName;
        this.currentLocation = field;
        this.score = 0;
    }

    static public Car attendCar(String carName){
        return new Car(carName, FIELD);
    }

    public int nowScore(){
            return score;
    }

}
