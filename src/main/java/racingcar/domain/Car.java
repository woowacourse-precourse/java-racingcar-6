package racingcar.domain;

public class Car {

    private String carName;
    private StringBuilder record;

    public Car(String carName){
        this.carName = carName;
        record = new StringBuilder();
    }

    public void forward(){
        record.append('-');
    }

    public String forwardRecord(){
        return record.toString();
    }



}
