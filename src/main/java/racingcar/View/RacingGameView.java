package racingcar.View;

import racingcar.Model.Car;

import java.util.List;

public class RacingGameView {
    public void displayStatus(List<Car> cars){

        for(Car car: cars){
            System.out.println(car.getName()+" : "+car.getMovement());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자: " + winnersString);
    }
}
