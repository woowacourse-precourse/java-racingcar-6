package racingcar.Model;

public class Car {
    private String carName;
    private String currentProgress = "";

    public void setCarName(String input){
        this.carName = input;
    }
    public String getCarName(){
        return this.carName;
    }
    public void addProgress(){
        this.currentProgress = this.currentProgress + '-';
    }
    public String getProgress(){
        return this.currentProgress;
    }
}
