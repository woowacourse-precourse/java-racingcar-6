package racingcar.view;

import racingcar.model.Car;
import racingcar.utils.Winner;

import java.util.ArrayList;
import java.util.List;
public class OutputView {
    public static void displayResults(List<Car> cars){
        for (Car car : cars){
            displayRound(car);
        }
    }

    public static void displayWinner(List<Car> cars){
        List<Car> winners= Winner.getWinners(cars);
        printWinner(winners);
    }

    public static void displayRound(Car car){
        String name = car.getName();
        int position = car.getPosition();
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners){
        if(winners.size()>1){
            printWinners(winners);
        }else{
            printSoloWinner(winners);
        }
    }

    public static void printWinners(List<Car> cars){
        List<String> winners = new ArrayList<>();
        for (Car car : cars){
            winners.add(car.getName());
        }
        String resultWinners=String.join(",",winners);
        System.out.println("최종 우승자 : "+resultWinners);
    }

    public static void printSoloWinner(List<Car> car){
        System.out.println("최종 우승자 : "+car.get(0).getName());
    }
}
