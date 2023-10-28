package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        Car cars = Input.makingLineup(names);

        System.out.println("시도할 회수는 몇회인가요?");
        String number = Console.readLine();
        int repeatTimes = Input.inputNumber(number);

        System.out.println();
        System.out.println("실행 결과");
        for (int i=0; i<repeatTimes; i++){
            cars.moveCar();
        }

        ArrayList<String> winnerList = cars.whoIsWinner();
        System.out.print("최종 우승자 : ");
        String winner = String.join(", ", winnerList);
        System.out.println(winner);
    }
}
