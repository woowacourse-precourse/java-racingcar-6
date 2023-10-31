package racingcar;

import java.util.ArrayList;

public class Winner {
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
