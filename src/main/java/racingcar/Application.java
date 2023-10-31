package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarsName = Console.readLine();

        Validate.validateInputCars(inputCarsName);

        Map<String, Integer> carsList = GameUtil.Savecars(inputCarsName);

        System.out.println("시도할 회수는 몇회인가요?");
        int inputTryNumber = Integer.parseInt(Console.readLine());

        Validate.validateInputNumber(inputTryNumber);


    }
}
