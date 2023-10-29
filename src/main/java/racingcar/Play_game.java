package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Play_game {
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
}
