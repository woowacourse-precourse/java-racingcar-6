package racingcar.View;

import racingcar.Model.Car;

import java.util.List;

public class OutputView {
    public static void printResult(){
        System.out.println("실행 결과");
    }

    public static void printCarName(Car car){
        System.out.print(car.getName() + " : ");
    }

    public static void print(){
        System.out.println();
    }

    public static void printCount(int num){
        for(int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }

    public static void printWinner(){
        System.out.print("최종 우승자 : ");
    }

    public static void printWinners(List<String> winners) {
        System.out.print(String.join(", ", winners));
    }
}
