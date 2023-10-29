package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public static void play(List<String> carNames, int tries) {
        List<Integer> distance = new ArrayList<Integer>();
        for ( int i = 0 ; i < carNames.size(); i++ ){
            distance.add(0);
        }
        for (int i = 0; i < tries; i++) {

            for (int j = 0; j < carNames.size(); j++) {
                int randoms = Randoms.pickNumberInRange(0, 9);
                if (randoms >= 4) {
                    int currentDistance = distance.get(j);
                    int newDistance = currentDistance + 1;
                    distance.set(j, newDistance);

                }
            }
            showRoundResults(carNames, distance);
        }
    }

    public static void showRoundResults(List<String> carNames, List<Integer> distance){


        for ( int i = 0; i< carNames.size(); i++ ){
            System.out.println(carNames.get(i) + " : " + generateHyphens(distance.get(i)));

        }
        System.out.println();
    }

    public static String generateHyphens(int distance){
        String hyphens = "";
        for( int i = 0; i < distance; i++){
            hyphens = hyphens + "-";
        }
        return hyphens;
    }
}

