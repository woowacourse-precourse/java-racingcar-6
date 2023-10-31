package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //입력
        String[] cars = Console.readLine().split(",");
        int playNum =0;
        while (true) {
            try {
                playNum = Integer.parseInt(Console.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("please enter number(0~9)");
            }
        }
        Console.close();

        //생성
        Game gm = new Game(cars, playNum);

        //실행
        gm.play(gm);
    }
}
