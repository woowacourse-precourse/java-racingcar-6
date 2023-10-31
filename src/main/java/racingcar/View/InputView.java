package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] inputGetCar() {
        //자동차 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputCar = Console.readLine();
        String[] getCar = inputCar.split(",");
        return getCar; //라이브러리 요구사항 준수
    }
    public static int inputGetRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int getCount = Integer.parseInt(Console.readLine()); //Integer.parseInt 붙여야 에러 안 남
        return getCount;
    }
}
