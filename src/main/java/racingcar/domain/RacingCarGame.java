package racingcar.domain;

public class RacingCarGame {
    private int number;
    private boolean gameState;

    public RacingCarGame(int number, boolean gameState){
        this.number = number;
        this.gameState = gameState;
    }

    public int getNumber() {
        return number;
    }
    public void moveRacingCar() {
        this.number = this.number - 1;
    }

    public boolean isGameState() {
        return gameState;
    }

    public void setGameState(){
        if(this.number==0){
            this.gameState=false;
        }
    }

}
