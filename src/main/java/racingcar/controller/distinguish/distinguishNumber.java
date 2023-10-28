package racingcar.controller.distinguish;

import camp.nextstep.edu.missionutils.Console;

public class distinguishNumber implements Distinguish{
    @Override
    public void distinguish(String data) {
        try{
            Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("제대로 된 숫자가 입력 되지 않았습니다.");
        }
    }
}
