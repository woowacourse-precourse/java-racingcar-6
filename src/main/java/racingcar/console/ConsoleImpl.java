package racingcar.console;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.domain.participant.Participant;

import java.util.List;

public class ConsoleImpl implements Console {
    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private String getPlayerInput() {
        return readLine();
    }

    @Override
    public String getPlayerCarNames() {
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
    public void displayState(String carName, int distance) {
        print(carName);
        print(" : ");
        for ( int i = 0; i < distance; i++ )
            print("-");
    }

    @Override
    public void displayWinner(List<Participant> winners) {
        print("최종 우승자 : ");
        for ( int i = 0; i < winners.size(); i++ ) {
            print(winners.get(i).getCarName());
            if ( i != winners.size() - 1 )
                print(", ");
        }
    }
}
