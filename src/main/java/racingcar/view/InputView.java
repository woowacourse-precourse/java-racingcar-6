package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

import java.util.*;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GAME_ROUND = "시도할 회수는 몇회인가요?";

    public static String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        String input = Console.readLine();
        validInputBlank(input);
        return input;
    }
    public static String inputGameRound(){
        System.out.println(INPUT_GAME_ROUND);
        String input = Console.readLine();
        validInputGameRound(input);
        return input;
    }

    public static ArrayList<Car> inputCars(ArrayList<String> carNames) {
        validInputCars(carNames);
        return createCarListByCarNames(carNames);
    }

    public static void validInputGameRound(String input) {
        validInputBlank(input);
        validInputInteger(input);
        validNotUnderZero(Integer.parseInt(input));
    }

    public static void validInputCars(ArrayList<String> carNames) {
        validCarNameBlank(carNames);
        validCarNameLength(carNames);
        validCarsDuplicate(carNames);
    }

    public static void validInputBlank(String input){
        if(input.isBlank()) throw new IllegalArgumentException(ErrorMessage.BLANK_STRING.message());
    }

    private static ArrayList<Car> createCarListByCarNames(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for(String car : carNames) cars.add(new Car(car));
        return cars;
    }

    private static void validCarNameLength(ArrayList<String> cars) {
        for(String car : cars){
            if(car.length() > 5) throw new IllegalArgumentException(ErrorMessage.REQUIRE_LENGTH_UNDER_FIVE.message());
        }
    }

    private static void validCarNameBlank(ArrayList<String> cars) {
        for(String car : cars){
            if (car.contains(" ")) throw new IllegalArgumentException(ErrorMessage.REQUIRE_NOT_BLANK.message());
        }
    }

    private static void validCarsDuplicate(ArrayList<String> cars){
        HashSet<String> set = new HashSet<>(cars);
        if(set.size() != cars.size()) throw new IllegalArgumentException(ErrorMessage.REQUIRE_NOT_DUPLICATE.message());
    }

    private static void validInputInteger(String input){
        for(int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException(ErrorMessage.REQUIRE_INTEGER_TYPE.message());
        }
    }

    private static void validNotUnderZero(int num){
        if(num<=0) throw new IllegalArgumentException(ErrorMessage.REQUIRE_OVER_ONE.message());
    }
}
