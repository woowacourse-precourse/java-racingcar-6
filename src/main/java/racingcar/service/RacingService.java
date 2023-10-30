package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class RacingService {
    public List<String> stringToList(String str) {
        String[] strArr = str.split(",");
        return new ArrayList<>(Arrays.asList(strArr));
    }

    public int generateRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> generateCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name, 0);
            cars.add(car);
        }
        return cars;
    }

    public List<Car> attempt(List<Car> cars) {
        for (Car car : cars) {
            int rNum = generateRandomNum();
            if (isMorethanDigit(rNum, 4)) { // 4 digit처리
                car.forward(rNum);
            }
        }
        printRacingResult(cars);
        return cars;
    }

    public void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for(int i=0;i<car.getCurrent();i++) { //함수(printBar)로 빼야되나
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isMorethanDigit(int digit, int num) {
        return digit <= num;
    }
}
