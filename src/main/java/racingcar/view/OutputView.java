package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {


    public static void printRaceResult(List<Car> carList) {
        System.out.println("실행 결과");
        for (Car car : carList) {
            System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
        }
        System.out.print("\n");
    }

    public static void printWinners(String name){
        System.out.print("최종 우승자 : "+ name);
    }
}
