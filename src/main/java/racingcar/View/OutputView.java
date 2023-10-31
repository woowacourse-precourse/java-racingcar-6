package racingcar.View;

import racingcar.Model.Car;

import java.util.List;

public class OutputView {

    public void finishGame(List<String> members) {
        String result = String.join(",", members);
        System.out.println("최종 우승자 : " + result);
    }

    public void progressResult(Car car) {
        System.out.print(car.getCarName() + " : ");
        for(int i = 0; i<car.getMovement(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
