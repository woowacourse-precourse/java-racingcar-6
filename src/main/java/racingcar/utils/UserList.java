package racingcar.utils;

import main.java.racingcar.model.Car;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;


//문자열을 입력 받아 ,로 이름을 분리하고 유효성 검사를 진행한 후 리스트로 반환
public class UserList {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    public static List<Car> getCarList() {
        String UsersName = Console.readLine();
        List<String> names = validationTest(UsersName);
        List<Car> Users = new ArrayList<>();
        for (String name: names) {
            Users.add(new Car(name));
        }
        return Users;
    }
    private static List<String> validationTest(String UsersName) {
        List<String> names = Arrays.asList(UsersName.split((",")));
        for (String name: names) {
            nameLengthCheck(name);
        }
        repeatedNameCheck(names);
        return names;
    }

    private static void nameLengthCheck(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    private static void repeatedNameCheck(List<String> names) {
        if(names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }


}
