package racingcar.Model;

public class Car {
    private String name;
    private String currentProgress;

    public Car(String name){
        this.name = name;
        this.currentProgress = "";
    }

    public void setCarName(String input){
        this.name = input;
    }
    public String getCarName(){
        return this.name;
    }
    public void addProgress(){
        this.currentProgress = this.currentProgress + '-';
    }
    public String getProgress(){
        return this.currentProgress;
    }
}
