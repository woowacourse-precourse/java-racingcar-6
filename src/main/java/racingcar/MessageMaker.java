package racingcar;

import java.util.ArrayList;
import java.util.List;

public class MessageMaker {
    private String returnMessage;
    public MessageMaker() {
        this.returnMessage = new String();
    }
    public String winnerMessage(List winners) {
        returnMessage = "";
        returnMessage = String.join(", ", winners);
        returnMessage = "최종 우승자 : " + returnMessage;
        return returnMessage;
    }

    public String playerLocationMessage(String name, int location) {
        returnMessage = "";
        returnMessage += name;
        returnMessage += " : ";
        for (int i = 0; i <= location; i++) {
            returnMessage += "-";
        }
        returnMessage += "\n";
        return String.join("",returnMessage);
    }
}
