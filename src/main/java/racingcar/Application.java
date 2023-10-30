package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(checkInputLineCarNames(getCarNames()));
    }

    public static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static String getCarNames() {
        printInputCarNames();
        String carNames = Console.readLine();
        return carNames;
    }
    public static List<String> saveCarNames(String carNames) {
        List<String> cars = Arrays.asList(carNames.split(","));
        return cars;
    }
    public static String checkInputLineCarNames(String inputCarNames) {
        checkStartWithInputLine(inputCarNames);
        checkLastIndexInputLine(inputCarNames);
        return inputCarNames;
    }
    public static void checkStartWithInputLine(String inputCarNames) {
        if(inputCarNames.startsWith(",")){
            throw new IllegalArgumentException();
        }
    }
    public static void checkLastIndexInputLine(String inputCarNames) {
        if(inputCarNames.lastIndexOf(",") == inputCarNames.length()-1){
            throw new IllegalArgumentException();
        }
    }

}
