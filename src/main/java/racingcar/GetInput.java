package racingcar;

import camp.nextstep.edu.missionutils.Console;
import static racingcar.Validation.*;

public class GetInput {
    public static String getCarNames() {
        return Console.readLine();
    }

    public static int getCounts() {
        int input =  Integer.parseInt(Console.readLine());
//        validateCounts(input);
        return 1;
    }

}
