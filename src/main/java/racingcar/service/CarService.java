package racingcar.service;

import static racingcar.service.ValidateService.isEmpty;
import static racingcar.service.ValidateService.isValidLength;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarService {
    private static CarService carService = new CarService();

    private String cars;
    private List<Car> parkingLot;
    private int carCount;

    private CarService(){
        parkingLot = new ArrayList<>();
    }

    public static CarService getInstance() {
        return carService;
    }

    public void isValidate(String carName){
        isEmpty(carName);
        isValidLength(carName);
    }
    public void parkParkingLot(String cars) throws IllegalArgumentException{ //입력값을 받은 cars를 "," 기준으로 분리하고 ParkingLot에 add
        String []tempParkingLot = cars.split(",");
        for(int i=0;i<tempParkingLot.length;i++){
            isValidate(tempParkingLot[i]);
            Car car = new Car();
            car.setCarName(tempParkingLot[i]);
            parkingLot.add(car);
        }
    }


}
