package racingcar.domain;

public class Car{
    private String carName;
    private int progressbar = 0;



    public void progressPlusOne(int bar) {
        progressbar+=bar;
    }

    public String getName(){
        return carName;
    }
    public void setName(String carName){this.carName = carName;}

    public int getProgressbar(){
        return progressbar;
    }
}


