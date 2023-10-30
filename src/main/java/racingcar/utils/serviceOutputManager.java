package racingcar.utils;

public class serviceOutputManager {

    private static final String WINNER_PRINT = "최종 우승자 : ";

    public void winnerPrint(String winners) {
        //todo
        System.out.println(WINNER_PRINT+winners);
    }

    public void printState(String name, Integer position) {
        String dash = "";
        for (int i = 0; i < position; i++) {
            dash += "-";
        }
        System.out.print(name + " : " + dash);
    }


}
