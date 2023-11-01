package racingcar.view;
import static racingcar.domain.Verification.checkEqualsAndThrowException;
import static racingcar.domain.Verification.throwCarNameLengthException;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
public class Output {

    public static List<String> carName(String input) {
        List<String> carNames = new ArrayList<>();
        for (String name : input.split(",")) {
            carNames.add(name);
            throwCarNameLengthException(name);
            checkEqualsAndThrowException(carNames);
        }
        return carNames;
    }

    public static void gameResult(){
        System.out.println("실행 결과");

    }

    public static void finalWinner(){
        System.out.println("최종 우승자 : ");
    }

    
}
