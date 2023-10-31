package racingcar;

import racingcar.domain.Announcer;
import racingcar.domain.Checker;
import racingcar.domain.Input;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        List<String> carsName = input.carsName();
        int numberOfAttempts = input.numberOfAttempts();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < carsName.size(); i++) {
            result.add(0);
        }
        Checker checker = new Checker();

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            for (int j = 0; j < carsName.size(); j++) {
                if (checker.advance()) {
                    result.set(j, result.get(j) + 1);
                }
            }
            for (int k = 0; k < carsName.size(); k++) {
                System.out.println(carsName.get(k) + " : " + "-".repeat(result.get(k)));
            }
            System.out.println("");
        }

        Announcer announcer = new Announcer();
        System.out.println(announcer.whoWin(result, carsName));
    }
}
