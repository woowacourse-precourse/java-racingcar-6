package racingcar;

public class Car {
    String name;
    int counter;
    String progressbar;

    Car(String name){
        this.name=name;
        this.counter=0;
        this.progressbar="";
    }

    int getCounter(){
        return this.counter;
    }

    void addProgress(){
        this.counter ++;
        this.progressbar += "-";
    }

    String showProgress(){
        return this.name+" : "+this.progressbar;
    }
}
