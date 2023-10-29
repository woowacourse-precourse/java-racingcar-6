package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
            // 기능 1-1. 자동차의 이름을 입력 받아 몇 대(n)의 자동차로 경기를 할 것인지 입력 받기
            String Input = getInput();
            // 입력 받은 자동차 이름들을 배열에 저장
            String[] cars = Input.split(",");
            // 기능 1-2. 주어진 횟수를 입력받기(몇 번의 라운드를 진행할 지 입력 받기)
            int rounds = getNumberOfRounds();
    }

    // 기능 1-1. 자동차의 이름을 입력 받아 몇 대(n)의 자동차로 경기를 할 것인지 입력 받기
    public static String getInput(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("쉼표(,)를 기준으로 구분하여 5자 이하의 자동차 이름을 입력해주세요.");
            String input = scanner.nextLine();
            scanner.close();
            return input;
    }
    // 기능 1-2. 주어진 횟수를 입력받기(몇 번의 라운드를 진행할 지 입력 받기)
    public static int getNumberOfRounds(){
        int rounds = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        return rounds;
    }
}
