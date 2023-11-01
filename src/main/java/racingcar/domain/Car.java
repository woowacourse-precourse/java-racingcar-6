package racingcar.domain;

public class Car {
    private String name;
    private int progressNumber;
    private String viewProgress;
    public Car(String name){
        this.name = name;
        this.progressNumber = 0;
        this.viewProgress ="";

    }

    public void addProgress(){
        this.progressNumber +=1;
    }
    public void addViewProgress(){
        this.viewProgress+="-";
    }
    public int getProgressNumber(){
        return this.progressNumber;
    }
    public String getViewProgress(){
        return this.viewProgress;
    }
    public String getName(){
        return this.name;
    }
}
