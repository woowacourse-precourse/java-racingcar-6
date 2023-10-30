package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

/**
 * GameConsole 의 구현 클래스입니다.
 */
public class GameConsoleUtil implements GameConsole {

        private static GameConsole instance;
        /**
         * 플레이어가 console 에 입력한 문자열을 반환합니다.
         * 플레이어의 입력은 자바의 Scanner 객체를 사용합니다.
         *
         * @return console 에 입력한 문자열
         */

        private GameConsoleUtil(){}

        public static GameConsole getInstance() {
                if (instance == null) {
                        instance = new GameConsoleUtil();
                }

                return instance;
        }

        @Override
        public String readInput() {
                return Console.readLine();
        }

        /**
         * 매개변수인 message 를 콘솔에 출력합니다.
         *
         * @param message
         */
        @Override
        public void printMessage(String message) {
                System.out.print(message);
        }

        /**
         * 매개변수인 message 를 콘솔에 출력 후 개행합니다.
         *
         * @param message
         */
        @Override
        public void printlnMessage(String message) {
                System.out.println(message);
        }
}
