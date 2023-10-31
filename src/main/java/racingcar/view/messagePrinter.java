package racingcar.view;

import java.util.List;
import racingcar.model.Car;


public class messagePrinter {
    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askTryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultTitle(){
        System.out.println("실행 결과");
    }

    public static void printResults(List<Car> cars){
        for(int i=0;i<cars.size();i++){
            String result = "";
            Car car = cars.get(i);
            for(int j=0;j<car.raceStatus;j++){
                result += "-";
            }
            System.out.println(car.carName +" : " + result);

        }
    }

}
