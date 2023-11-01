package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class RacingInfo {
    private static String[] names;
    private static int num;

    private RacingInfo(){}
    public static String[] getNames() {
        return names;
    }

    public static void setNamesAndNum() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = Console.readLine().split(",");
        // 이름이 5자를 초과할 때 예외처리
        for (int i = 0; i < names.length; i++) {
            if(names[i].length() > 5){
                throw new IllegalArgumentException();
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String n = Console.readLine();
        // 횟수로 숫자가 아닐 경우 예외처리
        if (!isInteger(n)) {
            throw new IllegalArgumentException();
        }
        num = Integer.parseInt(n);

        // 횟수가 음수인 경우 예외처리
        if (num < 0){
            throw new IllegalArgumentException();
        }
        System.out.println();
    }

    public static int getNum() {
        return num;
    }

    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
