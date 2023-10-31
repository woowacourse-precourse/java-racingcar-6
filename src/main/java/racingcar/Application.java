package racingcar;

public class Application {
    public static void main(String[] args) {
        Car test = new Car("박규일");
    }
}

 class Car {
    public String carName;
    public int raceStatus;
    public Car(String carNameInput){
        this.carName = carNameInput;
        this.raceStatus = 0;
    }

}

