package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) { //여기를 출력 및 인터페이스로 만들자
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        Car racing = Input.setRacingCarLineup(names);

        System.out.println("시도할 횟수는 몇회인가요?");
        String number = Console.readLine();
        int repeatTimes = Input.inputNumberOfGame(number);

        System.out.println();
        System.out.println("실행 결과");
        racing.runRace(repeatTimes);

        ArrayList<String> winnerList = racing.makeWinnerList();
        System.out.print("최종 우승자 : ");
        String winner = String.join(", ", winnerList);
        System.out.println(winner);
    }
}
