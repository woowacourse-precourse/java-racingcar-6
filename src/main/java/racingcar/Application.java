package racingcar;

import racingcar.domain.Carname;
import racingcar.domain.Count;
import racingcar.domain.Movecar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> inputcar = new ArrayList<>();

        Carname carname = new Carname();
        inputcar = carname.name();
        Count count = new Count();
        int usercount = count.usercount();
        Movecar movecar = new Movecar();
        movecar.print(usercount, inputcar);
    }
}