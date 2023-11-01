package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static List<Car> cars = new ArrayList<>();
    static ArrayList<String> winners = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        RacingSetting.createCars(Console.readLine().trim());
        System.out.println("시도할 회수는 몇회인가요?");
        Integer trialNumber = RacingSetting.saveTrialNumber(Console.readLine().trim());
        System.out.println("\n실행결과");
        DriveProcedure.drive(trialNumber);
        RacingResult.showWinner();
    }
}