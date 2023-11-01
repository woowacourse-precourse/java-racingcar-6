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

        public void printOutputMessage() {
            System.out.print(ServiceMessage.OUTPUT.serviceMessage);
        }

        public void printWinnerMessage(List<String> winners) {
            System.out.println(ServiceMessage.WINNER.serviceMessage + String.join(", ", winners));
        }

        public static void printRaceStatus(String[] names, int[] countsByName) {
            for(int t = 0; t < countsByName.length; t++) {
                String key = names[t];
                System.out.println(key + " : " + "-".repeat(countsByName[t]));
            }
            System.out.println();
        }
}
