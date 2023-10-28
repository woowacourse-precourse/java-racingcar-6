package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String Game_Start = Constants.GAME_START.toString();
        String TRY_COUNT = Constants.TRY_COUNT.toString();
        String WINNER = Constants.WINNER.toString();


        System.out.println(Game_Start);
        List<String> Cars = RacingCars.generateCar();
        System.out.println(TRY_COUNT);
        String tmp_count = Console.readLine();
        int count = Exceptions.Count(tmp_count);
        System.out.println(count);


    }
}