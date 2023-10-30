package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Preference {
    private final List<String> cars;
    private final int round;
    private final int nCars;

    public Preference() {
        this.cars = requestNames();
        this.round = requestRound();
        this.nCars = cars.size();
    }

    private static int requestRound() {
        System.out.println(Printer.REQUEST_ROUND);
        return Scanner.extractRound(Console.readLine());
    }

    private static List<String> requestNames() {
        System.out.println(Printer.REQUEST_NAME);
        return Scanner.extractNames(Console.readLine());
    }

    public int getSize() {
        return nCars;
    }

    public int getRound() {
        return round;
    }

    public List<String> getCars() {
        return cars;
    }
}
