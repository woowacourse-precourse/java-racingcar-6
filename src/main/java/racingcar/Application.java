package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
//import racingcar.Input_data;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<String> racer_name = new ArrayList<String>();
        ArrayList<String> distance = new ArrayList<String>();
        ArrayList<String> winner = new ArrayList<String>();
        int count;
        Input_data.input_cars(racer_name);

        count = input_number();

        racing_game(racer_name, distance, count);
        calculate_winner(racer_name, distance, winner);
        

    }

    public static int input_number() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input_str = Console.readLine();
        int number;

        try {
            number = Integer.parseInt(input_str);
        }
        catch (NumberFormatException ex){
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.", ex);
        }
        return number;
    }

    public static void racing_game(ArrayList<String> name, ArrayList<String> distance,int number) {
        System.out.println("실행 결과");
        initialize_distance(distance, name.size());
        for(int i=0; i<number; i++) {
            play_one_round(name, distance);
            System.out.println();
        }
    }

    public static void play_one_round(ArrayList<String> name, ArrayList<String> distance) {
        for(int j=0; j < name.size(); j++) {
                calculate_distance(distance, j);
                System.out.println(name.get(j) + " : " + distance.get(j));

            }
    }

    public static void initialize_distance(ArrayList<String> distance, int index) {
        for(int i=0; i < index; i++) {
            distance.add("");
        }
    }
    public static void calculate_distance(ArrayList<String> distance, int index){
        int rand_num = Randoms.pickNumberInRange(0,9);
        if(rand_num > 3) {
            
            distance.set(index, distance.get(index)+"-");
        }
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
