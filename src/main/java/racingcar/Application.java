package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<String> askRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        List<String> racingCars = List.of(userInput.split(","));

        //TODO : 쉼표가 아닌 다른 값으로 구분짓는다면 예외처리
        //TODO : 이름이 5자 초과일 시 예외처리
        return racingCars;
    }
    public static void main(String[] args) {
        System.out.println(askRacingCars());


    }
}
