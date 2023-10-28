package racingcar.domain.dto;

public class CarRecord {

    private String carName;
    private int number_of_step;

    public CarRecord(String carName, int number_of_step){
        this.carName = carName;
        this.number_of_step = number_of_step;
    }

    public String getCarName() {
        return carName;
    }

    public int getNumber_of_step() {
        return number_of_step;
    }
}
