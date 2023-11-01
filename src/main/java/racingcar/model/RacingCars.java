package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    List<Car> racingCarsList = new ArrayList<>();

    public static final int MIN_PICK_NUMBER = 0;
    public static final int MAX_PICK_NUMBER = 9;
    public static final int PICK_NUMBER_CONDITIONS = 4;

    // carNames 리스트의 각 이름에 대해 반복하면서 Car 객체 생성한 후 racingCarsList 리스트에 추가
    public RacingCars(List<String> carNames) {
        for (String carName : carNames) {
            racingCarsList.add(new Car(carName));
        }
    }

    public void MoveCars() {
        for (Car car : racingCarsList) {
            if (CreateRandomNum() >= PICK_NUMBER_CONDITIONS) {
                car.Move();
            }
        }
    }

    public int CreateRandomNum() {
        return Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
    }

    public List<Car> GetRacingCars() {
        return racingCarsList;
    }
}