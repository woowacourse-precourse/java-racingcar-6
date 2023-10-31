package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
    }

    public static void start(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static ArrayList<String> getName(){
        ArrayList<String> list = new ArrayList<>();
        String input = Console.readLine();

        for(String i : input.split(",")){
            list.add(i);
        }

        return list;
    }

    public static int getTry(){
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
