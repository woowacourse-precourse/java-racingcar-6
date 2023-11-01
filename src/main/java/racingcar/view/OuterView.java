package racingcar.view;

import racingcar.Const;
import racingcar.model.Car;

import java.util.List;

public class OuterView {

    public static void printStatus(int index, String status) {
        if (index == 0) {
            System.out.println();
            System.out.println(Const.ALERT_PRINT_RESULT_START);
        }

        System.out.println(status + "\n");
    }

    public static void printWinner(List<Car> winners) {
        StringBuilder sb = new StringBuilder(Const.WINNERS_STRING);
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName());
            if (i != winners.size() - 1) {
                sb.append(Const.WINNERS_SEPARATOR);
            }
        }

        System.out.println(sb);
    }
}
