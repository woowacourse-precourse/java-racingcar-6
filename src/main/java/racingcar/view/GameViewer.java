package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class GameViewer {
    private List<Car> cars;

    public GameViewer(List<Car> cars) {
        this.cars = cars;
    }

    public void displayGameResult() {

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getCarPositionString(car.getPosition()));
        }
        System.out.println();
    }

    private String getCarPositionString(int position) {
        String s = "-";
        s = s.repeat(position);

        return s;
    }

    public void displayGameWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

}
