package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String RESULT = "실행 결과";
    private static final String CAR_ADVANCE = "-";

    public static void executionResult(){
        System.out.println(RESULT);
    }

    public static void resultPerAttempt(List<Car> cars){
        for(Car car : cars){
            System.out.println(makeCarResult(car));
        }
    }

    public static void winner(){

    }

    private static String makeCarResult(Car car){
        StringBuilder sb = new StringBuilder();
        sb.append(car.getCarName());
        sb.append(" : ");

        for (int i = 0; i < car.getCarAdvances(); i++) {
            sb.append(CAR_ADVANCE);
        }

        return sb.toString();
    }
}
