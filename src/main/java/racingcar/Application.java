package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {


        final String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        final String TRY_COUNT = "시도할 회수는 몇회인가요?";
        final String RESULT = "\n실행 결과";
        final String WINNER = "\n최종 우승자: ";

        System.out.println( START );
        String carNameList = Console.readLine();
        System.out.println( TRY_COUNT );
        String activeCount = Console.readLine();


        Car car = new Car();
        boolean isValidName = car.validCarName( carNameList );

        Map<String, Integer> carMap = new HashMap<>();

        if ( isValidName ) {

            car.makeCarListToMap( carNameList, carMap );
        }

        System.out.println( RESULT );

        int count = 0;
        Racing racing = new Racing();
        String result = null;
        while ( count < Integer.parseInt( activeCount ) ) {

            for ( String key : carMap.keySet() ){
                int value = carMap.get( key );

                racing.increaseStepByRandomNum( carMap, key );

                StringBuilder step = racing.addStepForPrint( value );
                System.out.println( key + " : " + step );

                racing.makeRacingResultList( key, value, activeCount );
            }

            System.out.println();
            count++;

            result = racing.printResult();

        }
        if ( null == result ) {
            System.out.println( WINNER );
        } else  {
            System.out.println( WINNER + result );
        }
    }
}
