package racingcar.domain;

public class Car {

    private String carName;
    private int numberOfStep;

    public Car(String carName){
        this.carName = carName;
    }

    public void forward(int number){
        if(number < 4) return;

        addStep();
    }

    public String getCarName(){
        return carName;
    }

    public int getNowStep(){
        return numberOfStep;
    }

    private void addStep(){
        this.numberOfStep += 1;
    }

}
