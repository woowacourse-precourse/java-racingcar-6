package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Application {
    public static final String DELIMITER = ",";
    public static final String DASH = "-";

    public static Car[] car;
    public  static class Car {
        String name;
        int length;

        public Car(String name) {
            setName(name);
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setLength(int length) {
            this.length += length;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static ArrayList<String> getDash(Car car) {
        int dashNumber = car.length;
        ArrayList<String> dash = new ArrayList<>();
        while (dashNumber>0) {
            dash.add(DASH);
            dashNumber--;
        }
        return dash;
    }

    public static int moveForward() {
        int num = makeRandomNumber();
        int plusNum = 0;
        if (num >= 4) {
            plusNum++;
        }
        return plusNum;
    }

    public static void validateCarsName(String names) {
        boolean nameCheck = Pattern.matches("^[가-힣\\w]+[가-힣\\w" + "," + "]*[가-힣\\w]$",names);
        if(!nameCheck) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarsName2(ArrayList<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarsName3(ArrayList<String> names) {
        for (String element : names) {
            int length = element.length();
            if (length < 1 || length > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateCountNumber(String number) {
        boolean numCheck = Pattern.matches("^[1-9][0-9]*$",number);
        if(!numCheck) {
            throw new IllegalArgumentException();
        }
    }

    public static int makeRandomNumber() {
        int random;
        random = Randoms.pickNumberInRange(0,9);
        return random;
    }
}
