package racingcar;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Car> carList = new ArrayList<>();

    public void makeCars(String inputStr) {
        // 콤마로 구분한 자동차를 담아두는 임시 배열
        String[] carNameTempArr = splitByComma(inputStr);
        // 나눈 이름의 길이가 5 이하라면 cars에 Car 인스턴스 추가
        for (int i = 0; i < carNameTempArr.length; i++) {
            String carName = carNameTempArr[i];
            appendCar(carName);
        }
    }

    private static String[] splitByComma(String inputStr) {
        String[] carNameTempArr = inputStr.split(",");
        return carNameTempArr;
    }


    // 함수 이름 다시 생각. carList에 추가하는 내용 안들어감
    private void appendCar(String carName) {
        if (carName.length() <= 5) {
            carList.add(new Car(carName));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void tryDriving(int attemptNum) {
        // 입력받은 횟수만큼 각각의 자동차를 주행한다.
        for (int i = 0; i < attemptNum; i++) {
            drivingEachCar();
            // 각각의 자동차를 한 번씩 print하면 줄바꿈
            System.out.println();
        }
    }

    private void drivingEachCar() {
        for (Car car : carList) {
            car.driving();
            // 자동차의 누적 주행거리 print
            System.out.println(car.getCarName() + " : " + car.getDistanceDriven());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
