package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInputString = Console.readLine();

        List<String> userInputRacerNames = new ArrayList<>(Arrays.asList(userInputString.split(",")));
        List<Car> racingCars = new ArrayList<>();
        for (String racerName : userInputRacerNames){
            if (racerName.isBlank() || racerName.length()>5)
                throw new IllegalArgumentException();
            racingCars.add(new Car(racerName));
        }
        RacingController racingController;

        System.out.println("시도할 회수는 몇회인가요?");
        int userInputInt = Integer.parseInt(Console.readLine());

        if (userInputInt <= 0) throw new IllegalArgumentException();
        racingController = new RacingController(userInputInt, racingCars);  // automatically run proceedRound()
    }
}
