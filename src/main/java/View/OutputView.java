package View;

public class OutputView {
    public void roundResult(int position, String name) {
        System.out.printf("%s : ", name);
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}