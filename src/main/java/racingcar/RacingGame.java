package racingcar;

import camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;
import java.util.List;


//자동차 경주 (RacingGame 클래스) : 자동차의 경주 로직 기능


//setupCars(): 사용자 입력을 받아 자동차 객체들을 초기화하는 일
//validateCarNames(): 자동차 이름이 요구사항과 맞는지(5가 넘는지 확인)하는 일
//createCars(): 주어진 자동차 이름 배열로부터 자동차 객체들을 생성하는 일
//moveCars(): 각 자동차들을 움직이게 하는 일
//race(): 지정된 이동 횟수만큼 자동차들을 움직이게 하는 일

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void race(int moves) {
        for (int i = 0; i < moves; i++) {
            moveCars();
            ResultView.displayCarPositions(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }


    public static List<Car> setupCars() {
        String[] carNames = InputView.getCarNames();
        validateCarNames(carNames);

        return createCars(carNames);
    } // InputView의 getCarNames() 함수를 사용함
    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }


}
