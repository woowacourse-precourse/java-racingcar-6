package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printPlayResult() {
        System.out.println("실행 결과");
    }

    public static void printWinnerResult(List<String> carNameList) {
        System.out.print("최종 우승자 : "+carNameList.get(0));
        checkSoloWin(carNameList);
    }

    public static void printState(List<Car> carList) {
        for (Car car : carList) {
            printCarState(car);
        }
    }

    private static void printCarState(Car car) {
        System.out.println(car.getCar_name() + " : ");
        printDistance(car);
        System.out.println();
    }

    private static void printDistance(Car car) {
        for(int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
    }

    public static void printWinner(List<String> carNameList) {
        printWinnerResult(carNameList);
    }

    private static void checkSoloWin(List<String> carNameList) {
        if(carNameList.size() >= 1)
            printAnotherWinner(carNameList);
    }

    private static void printAnotherWinner(List<String> carNameList) {
        for(int i=1; i<carNameList.size(); i++)
            System.out.print(", "+carNameList.get(i));
    }
}
