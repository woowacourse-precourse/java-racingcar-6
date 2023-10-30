package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String Input = Console.readLine();
        String[] carNames = Input.split(",");


        System.out.println("시도할 회수는 몇회인가요?");
        int tries = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        displayResult(tries, carNames);
    }

    public static void displayResult(int tries, String[] carNames) {
        for (int i = 0; i < tries; i++) {
            System.out.println(carNames[0] + ":" );
            System.out.println(carNames[1] + ":" );
            System.out.println(carNames[2] + ":" );
            System.out.println();
        }

        System.out.println("촤종 우승자 : ");
    }
}

