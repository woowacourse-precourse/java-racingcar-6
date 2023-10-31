package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarController {
    private final List<Car> carList;

    public CarController(String[] carNames) {
        /* 입력받은 이름 배열 -> 리스트로 변환 */
        List<String> carNameList = Arrays.stream(carNames).toList();

        /* 입력 받은 이름들이 유효한지 확인 */
        carNameList.forEach(
                name -> checkCarNameLength(name));

        /* 입력 받은 이름으로 자동차 객체 생성 */
        carList = carNameList.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    /* 입력받은 자동차의 이름이 5자리를 넘으면 예외처리 */
    private void checkCarNameLength(String carName) {
        final int maxNameLength = 5;
        if (carName.length() > maxNameLength) { // 나중에 줄 나누기 (컨벤션 준수)
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.(입력된 이름: " + carName + ")");
        }
    }

    /* 모든 자동차를 움직이는지 체크 (moveForwardCheck 반복문처리) */
    public void tryToMoveForward() {
        carList.forEach(
                car -> moveForwardCheck(car)
        );
    }

    /* 랜덤으로 받은 숫자가 4보다 크면 해당 자동차를 움직임 */
    private void moveForwardCheck(Car car) {
        final int moveMinCondition = 4;
        if (moveMinCondition <= Randoms.pickNumberInRange(0, 9)) {
            car.moveCar();
        }
    }

    /* 자동차가 움직인 거리를 이름과 함께 출력 */
    public void printCarsMovePoint() {
        carList.forEach(
                car -> System.out.println(car.getForwardMoveCount())
        );
        System.out.print("\n");
    }

    /* 가장 많이 움직인 차의 전진 횟수 반환 */
    public Car getMaxMovePointCar() {
        return carList.stream()
                .max(Car::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    /* 가장 많이 움직인 자동차를 찾아 이름을 반환 */
    public List<String> findHaveSamePointCars(Car maxMovePointCar) {
        return carList.stream()
                .filter(maxMovePointCar::haveSamePoint)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

}
