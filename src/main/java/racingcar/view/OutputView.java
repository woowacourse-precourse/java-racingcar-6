package racingcar.view;


import java.util.ArrayList;
import java.util.List;
import racingcar.constants.Constants;
import racingcar.model.Car;

public class OutputView {
    public void showCarPosition(List<Car> carList) {
        for (Car car : carList) {
            String carName = car.getCarName();
            int carPosition = car.getCarPosition();
            System.out.println(carName + " : " + Constants.DASH_POSITION.repeat(carPosition));
        }
        System.out.println("");
    }

    public void showWinner(List<Car> carList, int maxNumber) {
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.checkWinner(maxNumber)) {
                winnerList.add(car.getCarName());
            }
        }
        String winners = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winners);
    }
}
