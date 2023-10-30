package racingcar.domain;

public class GameLogic {

    public void executeGame(String[] names, int[] result) {
        Random random = new Random();
        GoOrNot goOrNot = new GoOrNot();

        for (int i = 0; i < names.length; i++) {
            if (goOrNot.judgeNumber(random.makeRandomNum()) == Boolean.TRUE) {
                result[i] += 1;
            }
        }
    }
}
