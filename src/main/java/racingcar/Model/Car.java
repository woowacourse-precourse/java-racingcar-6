package racingcar.Model;

public class Car {
    private String name;
    private String currentProgress;
    private int progressCounter;

    public Car(String name){
        this.name = name;
        this.currentProgress = "";
        this.progressCounter = 0;
    }

    public void setCarName(String input){
        this.name = input;
    }
    public String getCarName(){
        return this.name;
    }
    public void addProgress(){
        this.currentProgress = this.currentProgress + '-';
        this.progressCounter++;
    }
    public String getProgress(){
        return this.currentProgress;
    }
    public int getProgressCounter(){
        return this.progressCounter;
    }
}
