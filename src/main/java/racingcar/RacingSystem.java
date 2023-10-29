package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RacingSystem {

    private static final String INPUT_CAR_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CNT_SENTENCE = "시도할 회수는 몇회인가요?";
    private static final String SEPARATOR = ",";
    private static final int MAX_COUNT = 5;
    private static final String NUMBER_REGEX = "^[0-9]*$";

    private List<Car> cars = new ArrayList<>();
    private Winners winners = new Winners();
    private int cnt = 0;

    public RacingSystem() {
    }

    public void inputCarName() {
        String input = write(INPUT_CAR_SENTENCE);
        try {
            checkValidName(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void inputTryCount() {
        String input = write(INPUT_CNT_SENTENCE);
        try{
            checkNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }

    private String write(String sentence) {
        System.out.println(sentence);
        return Console.readLine();
    }

    public void checkNumber(String input) {
        if(!isNumber(input) || !isUnderMax(input)) {
            throw new IllegalArgumentException();
        }
        this.cnt = Integer.parseInt(input);
    }

    private boolean isNumber(String str) {
        return Pattern.matches(NUMBER_REGEX, str);
    }

    private boolean isUnderMax(String str) {
        return Long.parseLong(str) <= Integer.MAX_VALUE;
    }

    public void checkValidName(String input) {
        String[] nameArray = input.split(SEPARATOR, -1);
        for(String name:nameArray){
            if(isInvalidName(name)) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name));
        }
    }

    private boolean isInvalidName(String name) {
        return isDuplicated(name)
                || isOverMaxCount(name)
                || isEmptyString(name);
    }

    private boolean isDuplicated(String name) {
        for(Car car: cars) {
            if(name.equals(car.getName())){
                return true;
            }
        }
        return false;
    }

    private boolean isOverMaxCount(String name) {
        return name.length() > MAX_COUNT;
    }

    private boolean isEmptyString(String name) {
        return name == null || " ".equals(name);
    }

}
