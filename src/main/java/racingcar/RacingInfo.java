package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class RacingInfo {
    private String[] names;
    private int num;

    public String[] getNames() {
        return names;
    }

    public void setNamesAndNum() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = Console.readLine().split(",");
        System.out.print("시도할 회수는 몇회인가요?");
        num = Integer.parseInt(Console.readLine());
        System.out.println();
    }

    public int getNum() {
        return num;
    }
}
