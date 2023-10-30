package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Car {

    private static final int NAME_STANDARD = 5;
    private static final int RUN_STANDARD = 4;
    private final String name;
    private String location = "";

    public Car(String name) {
        this.name = name;
        validateName(this.name);
    }

    private void validateName(String name) {
        if (name.length() > NAME_STANDARD) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void run() {
        if (checkRunCondition()) {
            this.location = location + "-";
        }
        System.out.println(this.getName() + " : " + this.getLocation());
    }

    private boolean checkRunCondition() {
        int runCondition = Randoms.pickNumberInRange(0,9);
        return runCondition >= RUN_STANDARD;
    }

    public static List<String> giveWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        sortByLocation(cars);
        addWinner(cars, winners);
        return winners;
    }
    private static void addWinner(List<Car> cars, List<String> winners) {
        winners.add(cars.get(0).getName());
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getLocation().length() != cars.get(0).getLocation().length()) {
                break;
            } else {
                winners.add(cars.get(i).getName());
            }
        }
    }
    private static void sortByLocation(List<Car> cars) {
        Comparator<Car> cp = (o1, o2) -> o2.getLocation().length() - o1.getLocation().length();
        cars.sort(cp);
    }

}
