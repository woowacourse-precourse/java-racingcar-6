package racingcar;

import java.util.List;

public class CarLocation {

    private RandomCarMovement randomCarMovement = new RandomCarMovement();


    public void carLocate(List<Car> carList) {

        for (Car car : carList) {
            // 차의 위치 가져오기
            Integer exist = car.getLocate();
            Integer move = randomCarMovement.randomTransfer();

            // 위치 업데이트
            car.setLocate(exist + move);

            // 출력
            System.out.println(car.getName() + " : " + "-".repeat(exist+move));
        }

    }
}
