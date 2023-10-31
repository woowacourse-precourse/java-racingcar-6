package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputRacingInformation {
    public List<String> InputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        StringTokenizer name_st = new StringTokenizer(names, ",");
        List<String> carNames = new ArrayList<>();
        while (name_st.hasMoreTokens()) {
            carNames.add(name_st.nextToken());
        }
        return carNames;
    }

    public int round_number() {
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            int round = Integer.parseInt(Console.readLine());
            return round;
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
