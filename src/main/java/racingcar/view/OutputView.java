package racingcar.view;

import java.util.List;
import racingcar.constant.Constant;
import racingcar.model.Car;

public class OutputView {
    private OutputView(){
    }

    public static void printOutputMessage(){
        System.out.println();
        System.out.println(Constant.OUTPUT_MESSAGE);
    }

    public static void printCars(List<Car> cars){
        for(Car car: cars){
            System.out.print(car.getName()+" : ");
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public static void printPosition(Integer position){
        for(int i = 0; i<position; i++){
            System.out.print("-");
        }
    }

    public static void printFinalistsName(List<String> finalists){
        System.out.print(Constant.OUTPUT_FINALIST_MESSAGE);
        for(int i = 0; i<finalists.size()-1; i++){
            System.out.print(finalists.get(i)+", ");
        }
        System.out.println(finalists.get(finalists.size()-1));
    }
}
