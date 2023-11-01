package racingcar.output;

import java.util.List;
import racingcar.constant.ServiceMessage;

public class ServicePrinter {

        public void printStartMessage() {
            System.out.print(ServiceMessage.START.serviceMessage);
        }

        public void printInputMessage() {
            System.out.print(ServiceMessage.INPUT.serviceMessage);
        }

        public void printWinnerMessage(List<String> winners) {
            System.out.println(ServiceMessage.WINNER.serviceMessage + String.join(", ", winners));
        }
}
