package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ViewInput {

    private static StringTokenizer carsToken;
    private static InputVerification inputVerification = new InputVerification();

    public List<String> getCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        carsToken = new StringTokenizer(Console.readLine(), ",");

        List<String> cars = new ArrayList<>();
        while(carsToken.hasMoreTokens()) {
            cars.add(carsToken.nextToken().trim());
        }

        inputVerification.verifyCarNamesInput(cars);

        return cars;
    }

    public int getNumberOfRounds() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int roundNumbers = Integer.parseInt(Console.readLine().trim());

        return roundNumbers;
    }
}
