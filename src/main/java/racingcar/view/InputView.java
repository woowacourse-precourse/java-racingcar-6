package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.Players;

public class InputView {

    private static final String START_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String START_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static void getStartNameMessage(){
        System.out.println(START_NAME_MESSAGE);
    }
    private static void getStartAttemptMessage(){
        System.out.println(START_ATTEMPT_MESSAGE);
    }

    public static Players getPlayersList(){

        getStartNameMessage();

        try {
            String playersInput = Console.readLine();

             return new Players(makePlayersList(playersInput));


        } catch (IllegalArgumentException e){

            throw new IllegalArgumentException(e.getMessage());

        }
    }

    public static int getAttempt(){
        getStartAttemptMessage();

        int attemptCount = Integer.parseInt(Console.readLine());

        return attemptCount;
    }

    private static List<String> makePlayersList(String playersInput){


        return Arrays.stream(playersInput.split(",")).toList();

    }
}
