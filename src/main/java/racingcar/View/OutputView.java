package racingcar.View;

import racingcar.Domain.Car;
import java.util.List;

public class OutputView {

    private static final String WINNERS_GUIDE = "최종 우승자 : ";
    private static final String RESULT_GUIDE = "실행 결과";

    public void printRacingResult(List<Car> cars){

        for (Car car : cars){
            printOneCarResult(car);
        }
        System.out.println();
    }

    private void printOneCarResult(Car car){
        System.out.printf(" %s : ",car.getName());
        for (int i=0; i< car.point; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(List<Car> cars){

    }




}
