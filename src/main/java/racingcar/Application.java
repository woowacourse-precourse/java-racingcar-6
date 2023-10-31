package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<String> car = askName();
        int num = tryNum();

        System.out.println(car);
        System.out.println(num);

    }

    public static Scanner scanner = new Scanner(System.in);

    public static List<String> askName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.next();

        List<String> carNames = new ArrayList<>();
        for(String name : input.split(",")){
            carNames.add(name);
        }
        return carNames;
    }

    public static int tryNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        int input = scanner.nextInt();

        return input;
    }
}
