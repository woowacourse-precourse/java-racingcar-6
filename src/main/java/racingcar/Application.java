package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


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
        System.out.println();

        System.out.println(RESULT);
        int[] Cars_Distance = new int[Cars.size()+1];
        for(int i = 0; i < count; i++){
            Cars_Distance = Race.Racing(Cars,Cars_Distance);
        }

        List<String> Winners = Winner.FindWinner(Cars,Cars_Distance);
        System.out.print(WINNER);
        System.out.print(String.join(", ",Winners));


    }
}