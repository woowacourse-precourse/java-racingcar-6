package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    List<Car> racingCarsList = new ArrayList<>();

    // carNames 리스트의 각 이름에 대해 반복하면서 Car 객체 생성한 후 racingCarsList 리스트에 추가
    public RacingCars(List<String> carNames) {
        for (String carName : carNames) {
            racingCarsList.add(new Car(carName));
        }
    }

    public void MoveCars() {
        for (Car car : racingCarsList) {
            if (CreateRandomNum() >= 4) {
                car.Move();
            }
        }
    }

    public int CreateRandomNum() {
        return Randoms.pickNumberInRange(0,9);
    }

    public List<Car> GetRacingCars() {
        return racingCarsList;
    }
}