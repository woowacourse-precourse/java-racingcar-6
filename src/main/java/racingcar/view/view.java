package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringTokenizer;

public class view implements ViewInterface{
    @Override
    public void inputCarName() {
        StringTokenizer st;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

    }
}
