package racingcar.model;

public class Car {
    private String carName;
    private int moveLength;
    public Car(String name) {
        carName = name;
        moveLength = 0;
    }

    public int getMoveLength() {
        return moveLength;
    }

    public String getCarName() {
        return carName;
    }

    public void moveForward(){
        int check = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
        if (check > 4)
            moveLength++;
    }
}
