package racingcar;

public class Car {
    private final String racerName;
    private int racingProgress;

    protected Car(String racerName){
        this.racerName = racerName;
        this.racingProgress = 0;
    }
    protected void incrementRacingProgress(){
        this.racingProgress++;
    }
    protected String getRacerName(){return this.racerName;}
    protected int getRacingProgress(){return this.racingProgress;}
    public String toString(){
        return this.racerName + " : " + "-".repeat(this.racingProgress);
    }
}
