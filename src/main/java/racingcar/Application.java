package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();
        // 구분 및 저장
        List<String> carList = Arrays.stream(inputCars.split(",")).filter(x -> Validate.checkLetterNum(x)).toList();
        System.out.println("시도할 회수는 몇회인가요?");
        Console.readLine();
    }
}
