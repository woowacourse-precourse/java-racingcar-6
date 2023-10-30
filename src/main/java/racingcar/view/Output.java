package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {

    public static void printInputCarNameInstruction(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printExecutionCountQuestion(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultOfExecution(List<Car> carList){
        System.out.println("실행 결과");
        for(Car car: carList){
            String driveTrace = "";
            for(int i=0; i<car.getLocation(); i++){
                driveTrace+="-";
            }
            System.out.printf("%s : %s\n",car.getName(), driveTrace);
        }
    }

}
