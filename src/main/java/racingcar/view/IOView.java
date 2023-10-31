package racingcar.view;

import java.util.List;

public class IOView {
    public void showSingleMessage(final String message){
        System.out.println(message);
    }
    public void showMessages(final List<String> message){
        for (String msg : message) {
            System.out.println(msg);
        }
    }
}
