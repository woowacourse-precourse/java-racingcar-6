package racingcar.View;

import java.util.ArrayList;
import racingcar.Model.Car;

public class outputView {
    public static String generateDashes(int input){
        return "-".repeat(Math.max(0, input));
    }

    public static void displayPlayResult(ArrayList<Car> cars){
        for(Car car: cars){
            System.out.println(car.getName()+":"+generateDashes(car.getCount()));
        }
    }

    public static void displayWinner(ArrayList<String> winners){
        for(String winner:winners){
            System.out.print(winner);
            if (!winner.equals(winners.get(winners.size() - 1))) {
                System.out.print(',');
            }
        }
    }
}
