package view;
import camp.nextstep.edu.missionutils.Console;
public class ConsoleInput implements Input{

    @Override
    public String input() {
       return Console.readLine();
    }
}
