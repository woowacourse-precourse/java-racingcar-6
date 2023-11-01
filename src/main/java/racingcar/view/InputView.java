package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;

public class InputView {

    public static List<Car> inputCars() {
        String[] arrCarNames = requestCarNames();
        List<Car> cars = responseCarNames(arrCarNames);
        return cars;
    }

        public static String[]  requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분, 5자 이하)");
        String input = readLine();
        String[] carNames = input.split(",");
        return carNames;
    }

    public static List<Car> responseCarNames(String[] carNames) {
        List<String> trimmedCarNames = doTrim(carNames);

        List<Car> cars = putCars(trimmedCarNames);

        return cars;
    }

    public static List<Car> putCars(List<String> trimmedCarNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : trimmedCarNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static List<String> doTrim(String[] carNames) {
        List<String> trimmedCarNames = new ArrayList<>();
        for (String carName : carNames) {
            trimmedCarNames.add(carName.trim());
        }
        return trimmedCarNames;
    }
    public static int inputRounds(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine().trim();
        int intCounts = stringToInteger(input);
        validateEqualMoreOne(intCounts);
        return intCounts;
    }
    public static int stringToInteger(String str){
        int intNum = Integer.parseInt(str);
        return intNum;
    }
    public static void validateEqualMoreOne(int num){
        if( !(num>=1)){
            throw new IllegalArgumentException("입력값은 1 이상이어야 합니다.");
        }
    }
}
