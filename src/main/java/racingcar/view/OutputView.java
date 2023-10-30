package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class OutputView {
    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            String distance = "";
            for(int i=0; i<car.getPosition(); i++) {
                distance += "-";
            }
            System.out.println(String.format("%s : %s", car.getName(), distance));
        }
        System.out.println();
    }
    
    public static void printWinner(List<Car> cars) {
        
    }

    public static void printRaceResultStart() {
        System.out.println("실행 결과");
    }
}
