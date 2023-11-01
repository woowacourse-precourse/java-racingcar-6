package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public final class IOView implements ConsoleView{
    @Override
    public void showSingleMessage(final String message) {
        System.out.println(message);
    }
    @Override
    public void showMessages(final List<String> message) {
        message.forEach(System.out::println);
    }
    @Override
    public void showHeadMessage(final String givenMessage) {
        System.out.print(givenMessage);
    }
    @Override
    public String readUserInput() {
        return Console.readLine();
    }
}
