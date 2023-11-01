package racingcar.service;

import static racingcar.service.ValidateService.hasBlank;
import static racingcar.service.ValidateService.isEmpty;
import static racingcar.service.ValidateService.isValidLength;
import static racingcar.util.Result.checkMaxDistance;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;

public class CarService {
    private static CarService carService = new CarService();

    private List<Car> parkingLot;
    private Set<String> carNames;


    private CarService() {
        parkingLot = new ArrayList<>();
        carNames = new HashSet<>();
    }

    public static CarService getInstance() {
        return carService;
    }

    public List<Car> getParkingLot() {
        return parkingLot;
    }

    public void isValidate(String carName) {
        isEmpty(carName);
        hasBlank(carName);
        isValidLength(carName);
    }

    public void parkParkingLot(String cars) throws IllegalArgumentException { //입력값을 받은 cars를 "," 기준으로 분리하고 유효성 검사
        String[] tempParkingLot = cars.split(",");
        for (int i = 0; i < tempParkingLot.length; i++) {
            isValidate(tempParkingLot[i]);
            carNames.add(tempParkingLot[i]);
        }
        parking(carNames);
    }

    private void parking(Set<String> carNames) { //중복 값이 처리된 Car이름을 parkingLot에 add
        for (String carName : carNames) {
            Car car = new Car();
            car.setCarName(carName);
            parkingLot.add(car);
        }
    }

    public void generateRandomNumbers() { //각 자동차 마다 랜덤 숫자 할당
        for (int i = 0; i < parkingLot.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            parkingLot.get(i).setRandomNumber(randomNumber);
        }
    }

    public void confirmRandomNumbers() { //각 자동차 마다 랜덤 숫자 확인해 전진할지 안할지 정해줌
        for (int i = 0; i < parkingLot.size(); i++) {
            if (parkingLot.get(i).getRandomNumber() >= 4) {
                parkingLot.get(i).setDistance("-");
            }
        }
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxDistance = checkMaxDistance(parkingLot);
        for (int i = 0; i < parkingLot.size(); i++) {
            if (parkingLot.get(i).getForwardDistance() == maxDistance) {
                winners.add(parkingLot.get(i).getCarName());
            }
        }
        return winners;
    }
}
