package racingcar.domain;

public class Car {
    String[] carNameArr;

    public String[] correctCarName(String cars) {
        //쉼표 기준으로 구분
        carNameArr = splitCarName(cars);
        //5글자 이하
        for (int i = 0; i < carNameArr.length; i++) {
            numberOfCharacters(i);
        }
        return carNameArr;
    }

    public void numberOfCharacters(int i) {
        if (carNameArr[i].length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String[] splitCarName(String cars) {
        String[] car = cars.split(",");
        return car;
    }
}