package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Preference {
    private List<String> cars;
    private int round;
    private int nCars;

    public Preference() {
        this.cars = requestNames();
        this.round = requestRound();
        this.nCars = cars.size();
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

    private static int requestRound() {
        System.out.println(Printer.REQUEST_ROUND);
        return Scanner.extractRound(Console.readLine());
    }

    private static List<String> requestNames() {
        System.out.println(Printer.REQUEST_NAME);
        return Scanner.extractNames(Console.readLine());
    }
}
