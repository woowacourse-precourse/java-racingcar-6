package racingcar;

import camp.nextstep.edu.missionutils.Console;
import inputprocess.InputProcess;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        // 이름 검사
        InputProcess test = new InputProcess(input);
        System.out.println(input);
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());
        System.out.println();
        System.out.println("실행 결과");






    }
}
