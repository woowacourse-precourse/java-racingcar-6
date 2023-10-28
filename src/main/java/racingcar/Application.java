package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String str = Console.readLine();
        String[] names = str.split(",");
        return names;
    }

    public static int inputNumber(){
        return Integer.parseInt(Console.readLine());
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String names[] = inputCarNames();
        int times = inputNumber();

        for(String s : names)
            System.out.println(s);

    }
}
