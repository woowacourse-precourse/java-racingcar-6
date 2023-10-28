package racingcar.view;

import java.util.List;
import racingcar.domain.dto.CarDTO;

public class RoundScreen {
    private static final String RESULTS_OF_ROUNDS = "실행 결과";
    private static final String SEPARATOR = " : ";
    private static final String POSITION_SIGN = "-";

    public static void startMessage(){
        System.out.println(RESULTS_OF_ROUNDS);
    }

    public static void printPositions(List<CarDTO> cars){
        cars.forEach(car -> {
            System.out.println(car.getName() + SEPARATOR + POSITION_SIGN.repeat(car.getPosition()));
        });
        System.out.println();
    }
}
