package racingcar.console;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.StringJoiner;

public class ConsoleImpl implements Console {
    private final String WINNERS_DELIMITER = ", ";

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void println() {
        System.out.println();
    }

    private String getPlayerInput() {
        return readLine();
    }

    @Override
    public String getPlayerNames() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getPlayerInput();
    }

    @Override
    public String getRaceCount() {
        println("시도할 회수는 몇회인가요?");
        return getPlayerInput();
    }

    @Override
    public void displayResultText() {
        println("실행 결과");
    }

    @Override
    public void displayStatus(String Name, int distance) {
        print(Name);
        print(" : ");
        for ( int i = 0; i < distance; i++ )
            print("-");
        println();
    }

    @Override
    public void displayWinners(List<String> winners) {
        StringJoiner joiner = new StringJoiner(WINNERS_DELIMITER);

        for ( String name : winners )
            joiner.add(name);

        print("최종 우승자 : " + joiner);
    }
}
