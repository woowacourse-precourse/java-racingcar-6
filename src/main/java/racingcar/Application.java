package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int inputNumberOfRepetitions() {
        System.out.println("시도할 회수는 몇회인가요?");

        try{
            return Integer.parseInt(readLine());
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하셔야 합니다.");
        }

    }

}
