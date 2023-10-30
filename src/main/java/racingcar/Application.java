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

        //실행
        gm.play(gm);

        Console.close();
    }
}
