package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Racing {

    List< String > winner;


    public Racing() {
        this.winner = new ArrayList<>();
    }

    public List<String> getWinner() {
        return winner;
    }

    public String printResult() {

        if ( !winner.isEmpty() ) {

            return String.join(", ", winner);
        }
        return null;
    }
    public void makeRacingResultList( String key, int activeValue, String inputActiveCount ){
        if ( Integer.parseInt( inputActiveCount ) == activeValue ) {

            winner.add( key );
        }
    }

    public StringBuilder addStepForPrint( int value ) {
        StringBuilder step = new StringBuilder();

        step.append( "-".repeat( Math.max(0, value) ) );
        return step;
    }

    public void increaseStepByRandomNum( Map<String,Integer> carMap, String key ) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        int value = carMap.get(key);
        if ( randomNumber > 3 ) {

            carMap.put( key, value + 1 );
        }
    }

}
