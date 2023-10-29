package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
            // 기능 1-1. 자동차의 이름을 입력 받아 몇 대(n)의 자동차로 경기를 할 것인지 입력 받기
            String Input = getInput();
    }

    // 기능 1-1. 자동차의 이름을 입력 받아 몇 대(n)의 자동차로 경기를 할 것인지 입력 받기
    public static String getInput(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("쉼표(,)를 기준으로 구분하여 5자 이하의 자동차 이름을 입력해주세요.");
            String input = scanner.nextLine();
            scanner.close();
            return input;
    }
}
