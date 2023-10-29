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
        calculate_winner(racer_name, distance, winner);
        

    }





    public static void calculate_winner(ArrayList<String> name, ArrayList<String> distance, ArrayList<String> winner){
        int best_record = 0;
        for(int i=0; i<name.size(); i++){
            if(distance.get(i).length() > best_record) {
                best_record = distance.get(i).length();
            }
        }

        for(int j=0; j<name.size(); j++) {
            if(distance.get(j).length() == best_record) {
                winner.add(name.get(j));
            }
        }

        String result_str = String.join(", ",winner);
        System.out.println("최종 우승자 : " + result_str);
    }
    
}
