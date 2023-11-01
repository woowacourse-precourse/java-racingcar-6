package racingcar;

public class Car implements Comparable<Car>{
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
    public String toString(){
        return this.racerName + " : " + "-".repeat(this.racingProgress);
    }

    @Override
    public int compareTo(Car another) {
        if (this.racingProgress < another.racingProgress) return -1;
        if (this.racingProgress > another.racingProgress) return 1;
        return 0;
    }
}
