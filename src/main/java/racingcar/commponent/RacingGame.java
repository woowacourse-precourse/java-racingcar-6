package racingcar.commponent;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.commponent.GameCondition.*;
import static racingcar.commponent.PrintGameState.*;

public class RacingGame implements Game {
    private String[] users;
    private StringBuilder[] state;
    private static Game game;

    private RacingGame() {}

    private void init() {
        inputUserInfo();
        String input = Console.readLine();
        boolean c = checkInputVal(input);

        if (c) {
            users = input.split(",");
            state = new StringBuilder[users.length];
            initializedState(state);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void play() {
        init();
        inputExecuteTime();
        String ext = Console.readLine();
        int executeTime = getRealValue(ext);
        racingStart(users, state, executeTime);
    }

    @Override
    public void test() {
        users = "pobi,woni,bani,sani,youngni".split(",");
        state = new StringBuilder[users.length];
        initializedState(state);
        state[0].append("-");
        state[1].append("-");
        state[2].append("-");
        state[3].append("-");
        state[4].append("-");
        racingTest(users, state, 2);
    }

    private boolean checkInputVal(String val) {
        // is not a split condition
        if (!val.contains(",")) {
            return false;
        }

        // is length over users name
        String[] users = val.split(",");
        for (String user : users) {
            if (user.length() > 5) {
                return false;
            }
        }

        return true;
    }

    public static Game getInstance() {
        if (game == null) {
            game = new RacingGame();
        }

        return game;
    }

    // real
    private void racingStart(String[] users, StringBuilder[] sb, int ext) {
        printExecuteInfo();
        for (int i = 0; i < ext; i++) {
            for (int j = 0; j < users.length; j++) {
                int r = getRandomVal();
                if (r >= MOVING_FORWARD.getValue()) {
                    sb[j].append("-");
                }
            }
            executeResult(users, sb);
        }

        String result = checkRacingResult(users, sb, ext);
        printRacingResult(result);
    }

    // test
    private void racingTest(String[] users, StringBuilder[] sb, int ext) {
        for (int i = 0; i < ext; i++) {
            executeResult(users, sb);
        }
        String result = checkRacingResult(users, sb, ext);
        printRacingResult(result);
    }

    private int getRandomVal() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private String checkRacingResult(String[] users, StringBuilder[] sbs, int ext) {
        StringBuilder sb = new StringBuilder();
        int[] saveIdx = new int[users.length];
        int cnt = 0;

        for (int i = 0; i < sbs.length; i++) {
            int userRacingResult = sbs[i].toString().length();

            if (userRacingResult == ext) {
                saveIdx[cnt] = i;
                cnt += 1;
            }
        }

        // not found winner
        if (cnt == 0) {
            return sb.toString();
        }

        // just one winner
        if (cnt == 1) {
            return sb.append(users[saveIdx[0]]).toString();
        }

        // one another
        for (int i = 0; i < cnt - 1; i++) {
            sb.append(users[saveIdx[i]]).append(", ");
        }
        sb.append(users[saveIdx[cnt - 1]]);

        return sb.toString();
    }

    private int getRealValue(String exT) {
        if (exT.length() > 1) {
            throw new IllegalArgumentException();
        }

        char v = exT.charAt(0);

        if (v < '0') {
            throw new IllegalArgumentException();
        } else if (v > '9') {
            throw new IllegalArgumentException();

        }

        return v - 48;
    }

    private void initializedState(StringBuilder[] sbs) {
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
    }
}
