package utils;

import java.util.Map;

public class MessageUtil {
    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void tryGame() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void runGame() {
        System.out.println("실행 결과");
    }

    public void endGame() {
        System.out.print("최종 우승자 : ");
    }

    public void outPut(String message) {
        System.out.println(message);
    }

    public void outPutResultCarName(String carName) {
        System.out.print(carName + " : ");
    }

}
