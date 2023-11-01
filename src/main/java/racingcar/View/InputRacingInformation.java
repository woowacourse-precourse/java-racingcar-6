package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

public class InputRacingInformation {
    public List<String> InputCarNames() {
        System.out.println(Constant.INPUT_CAR_NAME);
        String names = Console.readLine();
        StringTokenizer name_st = new StringTokenizer(names, ",");
        List<String> carNames = new ArrayList<>();
        while (name_st.hasMoreTokens()) {
            carNames.add(name_st.nextToken());
        }
        return carNames;
    }

    public int round_number() {
        System.out.println(Constant.INPUT_ROUND_NUMBER);
        try{
            int round = Integer.parseInt(Console.readLine());
            return round;
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_ROUND_NUM);
        }
    }
}
