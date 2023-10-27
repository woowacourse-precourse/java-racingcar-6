package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String inputCarNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String inputTryNumberMessage = "시도할 횟수는 몇회인가요?";

    public static String inputCarName(){
        System.out.println(inputCarNameMessage);
        return Console.readLine();
    }

    public static int inputTryNumber(){
        System.out.println(inputTryNumberMessage);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
