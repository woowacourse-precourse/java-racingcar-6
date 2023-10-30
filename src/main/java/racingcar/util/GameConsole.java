package racingcar.util;

/**
 * Game console 의 제공 로직을 정의한 인터페이스입니다.
 */
public interface GameConsole {
        /**
         * @implSpec 사용자가 console 에 입력한 문자열을 반환합니다.
         *
         * @return console 에 입력한 문자열 반환
         */
        String readInput();

        /**
         * @implSpec 매개변수로 주어진 메시지를 쿤솔에 출력합니다.
         *
         * @param message
         */
        void printMessage(String message);

        /**
         * @implSpec 매개변수로 주어진 메시지를 콘솔에 출력 후 개행합니다.
         *
         * @param message
         */
        void printlnMessage(String message);
}
