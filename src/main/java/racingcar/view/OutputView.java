package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public static void printCarsProgress(List<Car> cars){
        for(Car car : cars){
            printCarProgress(car);
        }
        System.out.println();
    }

    public static void printCarProgress(Car car){
        System.out.print(car.getName() + " : ");
        for(int i=0; i<car.getDistance(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(String name){
        System.out.print("최종 우승자 : " + name);
    }

    public static void printDeadHead(List<String> names){
        StringBuilder sb = new StringBuilder();
        System.out.print("최종 우승자 : ");
        for(String name : names){
            sb.append(name).append(", ");
        }

        if(names.size()>=2 && sb.length() > 0){
            sb.setLength(sb.length() - 2);
        }
        System.out.print(sb);
    }
}
