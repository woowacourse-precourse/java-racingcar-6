package racingcar;

public class SystemOutput {
    public void showStatus(String name, int location) {
        System.out.printf(name + " : ");
        for (int i = 0; i < location; i++) {
            System.out.printf("-");
        }
        System.out.println();
    }

    public void showResult() {

    }
}
