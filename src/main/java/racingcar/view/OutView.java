package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutView {

    public static void printMoveResult(List<Car> cars) {
        for(Car car : cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public static void printWinners(List<Car> winners){
        System.out.print("최종 우승자 : ");

        for(int i = 0; i < winners.size(); i++){
            if(i == winners.size() - 1){
                System.out.print(winners.get(i).getName());
            }
            if(i != winners.size() - 1) {
                System.out.print(winners.get(i).getName() + ", ");
            }
        }
    }
}