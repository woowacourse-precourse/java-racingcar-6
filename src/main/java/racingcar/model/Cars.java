package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 9;
    private int tryCount;

    private List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setCarList(String inputString) {
        String[] names = inputString.split(",");

        for (String name : names) {
            Car car = new Car(name.trim());
            carList.add(car);
        }
    }

    public void setTryCount(String tryCount) {
        tryCountValidation(tryCount);
        this.tryCount = convertStringToInt(tryCount);
    }

    public void moveCars() {
        for (Car car : carList) {
            car.run(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

    private int convertStringToInt(String tryCount){
        return Integer.parseInt(tryCount);
    }
    private void tryCountValidation(String tryCount){
        if(!isNumeric(tryCount)){
            throw new IllegalArgumentException();
        }
        if(Integer.parseInt(tryCount) < 1){
            throw new IllegalArgumentException();
        }
    }

    public boolean isNumeric(String inputString) {
        return inputString.matches("-?\\d+");  // 정수만 허용
    }
}
