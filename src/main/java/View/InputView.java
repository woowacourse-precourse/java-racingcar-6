package View;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class InputView {
    private static final String inputCarName = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분";
    private static final String inputNumOfAttempt = "시도할 회수는 몇회인가요?";
    public static String printUserInputCarName(){
        System.out.println(inputCarName);
        String input = readLine();
        return input;
    }

    public static Integer printUserInputNumOfAttempt(){
        System.out.println(inputCarName);
        Integer numOfAttempt = Integer.parseInt(readLine());
        return numOfAttempt;
    }
}
