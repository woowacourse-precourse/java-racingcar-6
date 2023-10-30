package racingcar.view;

import racingcar.model.Car;

import java.util.List;

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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void displayGameWinner(String winner) {
        if (winner.isEmpty()) {
            // 에러 처리
        } else {
            System.out.println("최종 우승자 : " + winner);
        }
    }

}
