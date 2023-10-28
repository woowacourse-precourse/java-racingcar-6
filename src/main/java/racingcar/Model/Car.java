package racingcar.Model;

public class Car {
    private String carName;
    private int movement;

    public Car(String carName) {
        checkNameLength(carName);
        this.carName = carName;
        this.movement = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName){
        this.carName = carName;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    private void checkNameLength(String nameCheck) throws IllegalArgumentException{
        if (nameCheck.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
