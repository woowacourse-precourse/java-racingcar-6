package racingcar;

public class Lap implements Showable{
    private static final String lapInstruction = "시도할 회수는 몇회인가요?";

    @Override
    public void showMessage() {
        System.out.println(lapInstruction);
    }
}
