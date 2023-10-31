package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

import java.util.*;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GAME_ROUND = "시도할 회수는 몇회인가요?";
    private static final String BLANK_STRING = "입력 문자열이 비어 있습니다.";
    private static final String REQUIRE_LENGTH_UNDER_FIVE = "자동차 이름을 5자 이하로 입력해주세요.";
    private static final String REQUIRE_INTEGER_TYPE = "자동차 이름을 정수 값을 입력해주세요.";
    private static final String REQUIRE_NOT_BLANK = "자동차 이름을 공백 없이 입력해주세요.";
    private static final String REQUIRE_NOT_DUPLICATE = "자동차 이름을 중복 없이 입력해주세요.";
    private static final String REQUIRE_OVER_ONE = "1회 이상 게임이 진행 되어야 합니다.";

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
        validCarNameBlank(carNames);
        validCarNameLength(carNames);
        validCarsDuplicate(carNames);

        ArrayList<Car> cars = new ArrayList<>();
        for(String car : carNames) cars.add(new Car(car));
        return cars;
    }

    public static void validInputBlank(String input){
        if(input.isBlank()) throw new IllegalArgumentException(BLANK_STRING);
    }

    public static void validCarNameLength(ArrayList<String> cars) {
        for(String car : cars){
            if(car.length() > 5) throw new IllegalArgumentException(REQUIRE_LENGTH_UNDER_FIVE);
        }
    }

    public static void validCarNameBlank(ArrayList<String> cars) {
        for(String car : cars){
            if (car.contains(" ")) throw new IllegalArgumentException(REQUIRE_NOT_BLANK);
        }
    }

    public static void validCarsDuplicate(ArrayList<String> cars){
        HashSet<String> set = new HashSet<>(cars);
        if(set.size() != cars.size()) throw new IllegalArgumentException(REQUIRE_NOT_DUPLICATE);
    }

    public static void validInputGameRound(String input) {
        validInputBlank(input);
        validInputInteger(input);
        validNotUnderZero(Integer.parseInt(input));
    }

    public static void validInputInteger(String input){
        for(int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException(REQUIRE_INTEGER_TYPE);
        }
    }

    public static void validNotUnderZero(int num){
        if(num<=0) throw new IllegalArgumentException(REQUIRE_OVER_ONE);
    }
}
