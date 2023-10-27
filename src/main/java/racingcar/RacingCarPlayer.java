package racingcar;

public class RacingCarPlayer {
    private final String carName;
    //현재 위치
    private int currentPosition;

    public RacingCarPlayer(String carName, int finalPosition) {
        this.carName = carName;
        this.currentPosition = 0;
    }

    public void move() {
        this.currentPosition++;
    }

    public void printPosition(){
        System.out.print(carName + " : ");
        for(int i = 0; i < this.currentPosition; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
