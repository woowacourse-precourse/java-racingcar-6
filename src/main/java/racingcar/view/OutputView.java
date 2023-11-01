package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Race;

import java.util.*;

public class OutputView {
    private static final String RACE_RESULT = "실행 결과";
    private static final String FINNAL_WINNER = "최종 우승자 ";
    private static final String COLON = ": ";
    private static final String ADVANCE = "-";

    public static void firstComment(){
        System.out.println(RACE_RESULT);
    }

    public static void showCurrentMove(Race race){
        List<Car> carRepository = race.getCarRepository();
        for (Car car : carRepository) {
            System.out.print(car.getName() + " " + COLON);
            for(int i = 0; i < car.advanceNum; i++) {
                System.out.print(ADVANCE);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners){
        System.out.print(FINNAL_WINNER + COLON);
        for(int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if(i == winners.size() - 1) break;
            System.out.print(", ");
        }
        System.out.println();
    }
}
