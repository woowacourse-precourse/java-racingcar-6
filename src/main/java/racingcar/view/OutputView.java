package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String GAME_RESULT_TITLE_MESSAGE = "실행 결과";
    private static final String GAME_RESULT_WINNER_MESSAGE = "최종 우승자 : ";
    public static void printTitle(){
        System.out.println(GAME_RESULT_TITLE_MESSAGE);
    }

    public static void printScore(RacingGame racingGame){
        List<Car> cars = racingGame.getCars();
        for (Car car : cars){
            printCarScore(car);
        }
        System.out.println();
    }

    private static void printCarScore(Car car){
        System.out.print(car.getName() + " : ");
        printCarPosition(car);
        System.out.println();
    }

    private static void printCarPosition(Car car){
        for (int i = 0; i < car.getPosition(); i++){
            System.out.print("-");
        }
    }

    public static void printWinners(List<Car> cars){
        List<String> winners = new ArrayList<>();
        for (Car car : cars){
            winners.add(car.getName());
        }

        String winnerMessage = GAME_RESULT_WINNER_MESSAGE + String.join(", ", winners);
        System.out.println(winnerMessage);
    }
}
