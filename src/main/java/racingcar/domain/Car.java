package racingcar.domain;

public class Car {
    private final String carName;
    private int moveCnt;

    public static final String CAR_STATE_FORMAT = "%s : ";
    public Car(String carName) {
        this.carName = carName;
    }

    public void moveForward(){
        moveCnt++;
    }

    public String getState(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(CAR_STATE_FORMAT, carName));
        for (int i=0;i<moveCnt;i++){
            sb.append('-');
        }
        return sb.toString();
    }

    public Integer getMoveCnt(){
        return moveCnt;
    }

    public String getName(){
        return carName;
    }
}
