package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static java.util.Arrays.fill;

public class Application {
    public static void main(String[] args) {
        String Game_Start = Constants.GAME_START.toString();
        String TRY_COUNT = Constants.TRY_COUNT.toString();
        String WINNER = Constants.WINNER.toString();
        String RESULT = Constants.RESULT.toString();



        System.out.println(Game_Start);
        List<String> Cars = RacingCars.generateCar();

        System.out.println(TRY_COUNT);
        String tmp_count = Console.readLine();
        int count = Exceptions.ExceptCount(tmp_count);

        int[] Cars_Distance = new int[Cars.size()+1];
        System.out.println(RESULT);
        for(int i = 0; i < count; i++){
            Cars_Distance = Race.Racing(Cars,Cars_Distance);
        }

    }
}