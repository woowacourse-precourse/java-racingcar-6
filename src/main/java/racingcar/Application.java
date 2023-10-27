package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static final Pattern INPUT_PATTERN = Pattern.compile("^[a-zA-Z]{1,5}$");
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // 자동차는 최소 1대, 자동차 이름은 최소 1글자 ~ 최대 5글자의 알파벳
    public static void input(){
        String s = Console.readLine();

        List<String> cars = Arrays.asList(s.split(","));
        if(cars.isEmpty()){
            throw new IllegalArgumentException("경주를 위해서는 자동차는 최소 1대 이상 필요해요.");
        }
        for (String car : cars) {
            if(!INPUT_PATTERN.matcher(car).matches()){
                throw new IllegalArgumentException("자동차 이름은 1글자에서 5글자 사이의 알파벳만 가능해요/");
            }
        }
    }
}
