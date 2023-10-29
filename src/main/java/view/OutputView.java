package view;

import domain.Car;

import java.util.List;

public class OutputView {

    public static final String PRINT_FINAL_RESULT = "최종 우승자 : ";

    public void printFinalResult(List<String> winners) {
        System.out.print(PRINT_FINAL_RESULT);
        for(String winner : winners) {
            System.out.print(winner);
        }
    }
    public void printEachResult(List<Car> cars, List<Integer> randomNumber) {
        for(int i=0; i<cars.size(); i++) {
            System.out.println(cars.get(i).getName()+" : ");
            printEachRandomResult(randomNumber.get(i));
        }
    }
    public void printEachRandomResult(int randomNumber) {
        for(int i=0; i<randomNumber; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
