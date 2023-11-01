package View;

import java.util.List;

public class OutputView {
    public void roundResult(int position, String name) {
        System.out.printf("%s : ", name);
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public void oneWinner(List<String> name) {
        System.out.printf("%s", name.get(0));
    }

    public void someWinner(List<String> name) {
        System.out.printf("%s", name.get(0));
        for (int i = 1; i < name.size(); i++) {
            System.out.printf(", %s", name.get(i));
        }
    }
}