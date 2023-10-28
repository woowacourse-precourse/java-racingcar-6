package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void start() {
        /**
         * 1. 차 이름 입력 받기
         * 2. 시도 횟수 입력 받기
         * 3. 실행
         * 4. 실행 결과 표시
         */
        List<Car> carList = makeCar();
        int numberOfAttempts = getNumberOfAttempts();
        for (int count = 0; count < numberOfAttempts; count++) {
            play(carList);
            showResult();
        }
    }

    private List<Car> makeCar() {
        CarName carName = new CarName(Console.readLine());
        List<String> carNameList = carName.getCarNameStrList();
        List<Car> carList = new ArrayList<>();
        for (int idx = 0; idx < carNameList.size(); idx++) {
            Car car = new Car(carNameList.get(idx));
            carList.add(car);
        }
        return carList;
    }

    private int getNumberOfAttempts() {
        Attemp attemp = new Attemp(Console.readLine());
        return attemp.getNumber();
    }

    private void play(List<Car> carList) {


    }

    private void showResult() {

    }
}
