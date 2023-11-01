package racingcar.domain;

public class Car{
    private final String carName;
    private int progressbar;

    public Car(String carName){
        this.carName=carName;
        this.progressbar=0;
    }

     public String getName(){
        return carName;
    }

    public int getProgressbar(){
        return progressbar;
    }

    public void progressPlusOne(){
        progressbar++;
}
}



