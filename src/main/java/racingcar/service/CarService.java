package racingcar.domain;

public class CarList {
    private static CarList carList = new CarList();

    private String userInput;
    private String[] carL;
    private int carCount;

    private CarList(){}

    public static  getInstance() { //3단계
        return service;
    }
}
