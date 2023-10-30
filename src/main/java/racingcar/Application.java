package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //입력
        String[] cars = Console.readLine().split(",");
        int playNum = Integer.parseInt(Console.readLine());

        //생성
        Game gm = new Game(cars, playNum);
        Referee rf = new Referee();

        //실행
        for (int i = 0; i < playNum; i++) {
            gm.play();
            System.out.println(rf.reportNow(gm));
        }
        System.out.println(rf.announceWinner(gm));

        Console.close();
    }
}
