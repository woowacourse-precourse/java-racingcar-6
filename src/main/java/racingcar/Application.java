package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            RacingGame game = new RacingGame();
            game.init();
        }finally{
            // Console.readLine() 메서드 사용 시 Scanner 객체가 생성되는데,
            // 예외 발생 후 프로그램이 종료되기 전에 Console.close()로 객체를 닫아줌
            Console.close();
        }

    }
}

