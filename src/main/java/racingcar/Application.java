package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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
        enterName();
        int count = enterTryNum();
        System.out.println("\n실행 결과");
        while (count>0) {
            printDashes(car);
            System.out.print("\n");
            count--;
        }
        findWinner(car);
        Console.close();
    }

    public static int enterTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNum = Console.readLine();
        validateCountNumber(tryNum);
        return Integer.parseInt(tryNum);
    }

    public static void enterName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        validateCarsName(names);
        String[] strArr = names.split(",");
        ArrayList<String> carNames;
        carNames = new ArrayList<>(Arrays.asList(strArr));
        validateCarsName2(carNames);
        validateCarsName3(carNames);
        int num = carNames.size();
        car = new Car[num];
        for (int i = 0; i < num; i++) {
            car[i] = new Car(carNames.get(i));
            car[i].setLength(0);
        }
    }

    public static void printDashes(Car[] car) {
        ArrayList<String> dashes = new ArrayList<>();
        for(Car e : car) {
            int number = moveForward();
            String racerName = e.getName();
            e.setLength(number);
            dashes = getDash(e);
            String realDashes = String.join("",dashes);
            System.out.println(racerName + " : " + realDashes);
        }
    }

    public static int getMaxNumber(Car[] car) {
        int max = 0;
        for (Car e : car) {
            int length = e.length;
            if (max < length) {
                max = length;
            }
        }
        return max;
    }

    public static void findWinner(Car[] car) {
        int max = getMaxNumber(car);
        ArrayList<String> nameList = new ArrayList<>();
        for (Car e: car) {
            if (e.length == max) {
                nameList.add(e.getName());
            }
        }
        String finalWinner = String.join(", ",nameList);
        System.out.printf("최종 우승자 : " + finalWinner);
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
