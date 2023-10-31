package racingcar;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<String> racer_name = new ArrayList<String>();
        ArrayList<String> distance = new ArrayList<String>();
        ArrayList<String> winner = new ArrayList<String>();
        int count;
        Input_data.input_cars(racer_name);

        count = Input_data.input_number();

        Play_game.racing_game(racer_name, distance, count);
        Winner.calculate_winner(racer_name, distance, winner);
        

    }





    
    
}
