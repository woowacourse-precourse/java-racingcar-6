package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

    public static void validateCarsName(String names) {
        boolean nameCheck = Pattern.matches("^[가-힣\\w]+[가-힣\\w" + "," + "]*[가-힣\\w]$",names);
        if(!nameCheck) {
            throw new IllegalArgumentException();
        }
    }

    public static int makeRandomNumber() {
        int random;
        random = Randoms.pickNumberInRange(0,9);
        return random;
    }
}
