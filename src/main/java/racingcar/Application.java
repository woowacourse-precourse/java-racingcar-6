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

        System.out.println( START );
        String carNameList = Console.readLine();
        System.out.println( TRY_COUNT );
        String activeCount = Console.readLine();


        Car model = new Car();
        boolean isValidName = model.validCarName( carNameList );

        if ( isValidName ) {

            //todo
        }

    }
}
