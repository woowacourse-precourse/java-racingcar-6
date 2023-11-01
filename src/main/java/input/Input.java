package input;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input implements InputModule{
    @Override
    public List<String> readCarName() {
        String input = Console.readLine();
        List<String> racers = List.of(input.trim().split(","));
        return racers;
    }

    @Override
    public int readTryNum() {
        String input = Console.readLine();
        int tryNum = Integer.parseInt(input);
        return tryNum;
    }
}
