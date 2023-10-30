package racingcar;


import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Racing;
import racingcar.domain.RacingCar;

import java.lang.reflect.Array;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        Racing racing = new Racing();

        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = racingCar.nameInput();
        List<String> cars = racingCar.naming(input);

        System.out.println("시도할 횟수는 몇회인가요?");
        int attemptInput = racingCar.attemptInput();

        System.out.println("실행 결과");
        String[] raceResult = new String[cars.size()];
        Map<String,String> rank = new HashMap<>();

        for(int i=0; i<attemptInput; i++) {
            racing.moveResult(cars, raceResult);
            for(int j=0; j<cars.size(); j++) {
                System.out.println(cars.get(j) + " : " + raceResult[j]);
            }
            System.out.println();
        }

        String getWinnerData = Collections.max(List.of(raceResult));
        List<String> winner =new ArrayList<>();

        for(int i=0; i<raceResult.length; i++) {
            if(getWinnerData==raceResult[i]) {
                winner.add(cars.get(i));
            }
        }
        String result = String.join(",", winner);
        System.out.println("최종 우승자 : "+result);
    }
}
