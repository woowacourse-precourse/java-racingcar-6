package racingcar.view;

import racingcar.Const;

public class OuterView {

    public static void printStatus(int index, String status) {
        if (index == 0) {
            System.out.println(Const.ALERT_PRINT_RESULT_START);
        }

        System.out.println(status + "\n");
    }
}
