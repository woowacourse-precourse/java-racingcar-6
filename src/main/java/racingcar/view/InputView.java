package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.Players;

public class InputView {

    private static final String START_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String START_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static void getStartNameMessage() {
        System.out.println(START_NAME_MESSAGE);
    }

    private static void getStartAttemptMessage() {
        System.out.println(START_ATTEMPT_MESSAGE);
    }

    public Players getPlayersList() {

        getStartNameMessage();

        try {
            String playersInput = Console.readLine();

            return new Players(makePlayersList(playersInput));


        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException(e.getMessage());

        }
    }

    public int getAttempt() {
        getStartAttemptMessage();
        int attemptCount;
        String input;

        try {

            input = Console.readLine();

            checkAttemptCount(input);

            Console.close();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        attemptCount = Integer.parseInt(input);
        return attemptCount;
    }

    private void checkPlayersInput(List<String> playersInput) {

        playersInput.stream().forEach(player -> {
            if (player.length() >= 6) {
                throw new IllegalArgumentException("경주할 자동차 이름은 5자 이하만 가능합니다.");
            }
        });

    }

    public void checkAttemptCount(String input) {

        checkInputNotNumber(input);

        checkInputZero(input);

    }

    private void checkInputNotNumber(String input) {

        for (char eachNumber : input.toCharArray()) {

            if (eachNumber < 48 || eachNumber > 57) {
                throw new IllegalArgumentException("잘못된 숫자입니다.");
            }
        }


    }

    private void checkInputZero(String input) {

        if (input.length() == 1 && input.charAt(0) == '0') {
            throw new IllegalArgumentException("횟수가 0 번은 부적절합니다!");
        }

    }

    private List<String> makePlayersList(String playersInput) {

        List<String> playersList = Arrays.stream(playersInput.split(",")).toList();

        checkPlayersInput(playersList);

        return playersList;

    }
}
