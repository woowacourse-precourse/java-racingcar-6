package racingcar.model;

public class RacingCarPlayerModel {
    private final String carName;
    //현재 위치
    private int currentPosition;

    public RacingCarPlayerModel(String carName) {
        this.carName = carName;
        this.currentPosition = 0;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getCarName() {
        return carName;
    }

    public void move(){
        if(util.RacingCarRandoms.getRandomNumber() >= 4){
            this.currentPosition++;
        }
    }
}
