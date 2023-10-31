package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(getCar().toString());
    }

    public static String[] getCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String answer = Console.readLine();
        String[] carNames = answer.split(",");
        return carNames;
    }

    public static int getCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String answer = Console.readLine();
        //TODO: Max값 확인도 해야하지 않을까?
        if (!answer.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(answer);
    }

    
}
