package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarList;

public class RacingCarView {

    private final String LOCATION = "-";

    public void carNameListInputPrint() {
        System.out.println("경주할 자동차 이름을 입력하시오");
    }


    public void readCountPrint() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void gameProgressPrint(CarList carList) {
        for (Car car : carList.getCarList()) {
            int location = car.getLocation();
            System.out.println(car.getName() + " : " + LOCATION.repeat(location));
        }
        System.out.println();
    }

}
