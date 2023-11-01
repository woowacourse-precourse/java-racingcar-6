package racingcar;
import java.util.Collections;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Move {
    ArrayList<Integer> dist = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    int times = 0;

    private boolean chance() {
        if (Randoms.pickNumberInRange(0, 9) < 4) {
            return false;
        }
        return true;
    }

    private void run(Integer index) {
        if (chance()) {
            dist.set(index, dist.get(index) + 1);
        }
        System.out.printf("%s : %s\n", names.get(index), "-".repeat(dist.get(index)));
    }

    private int makeMovement() {
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < names.size(); j++) {
                run(j);
            }
            System.out.println();
        }

        return Collections.max(dist);
    }

    public void move(ArrayList<String> names, int times) {
        this.names = names;
        this.times = times;

        for (int i = 0; i < names.size(); i++) {
            this.dist.add(0);
        }

        return;
    }
}
