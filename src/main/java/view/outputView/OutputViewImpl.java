package view.outputView;

import java.util.List;

public class OutputViewImpl {
    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners));
    }
}
