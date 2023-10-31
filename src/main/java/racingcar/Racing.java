package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class Racing {
    private int racingRound;
    LinkedHashMap<String, String> cars;
    List<String> rank;

    public void inputRacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name;
        name = inputCarName();
        checkNullInputCar(name);
        name = deleteSpace(name);
        checkSpecialCharacter(name);
        splitRacingCar(name);
    }

    public String inputCarName() {
        String name;
        name = Console.readLine();
        return name;
    }

    public String deleteSpace(String name) {
        name = name.replaceAll(" ", "");
        return name;
    }

    public void checkNullInputCar(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkSpecialCharacter(String name) {
        if (!name.matches("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝|,]*")) {
            throw new IllegalArgumentException();
        }
    }

    public void splitRacingCar(String name) {
        cars = new LinkedHashMap<>();
        String[] split = name.split(",");
        for (String each_name : split) {
            checkNameLength(each_name);
            checkDuplicateCar(each_name);
            cars.put(each_name, "");
        }
    }

    public void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicateCar(String name) {
        if (cars.containsKey(name)) {
            throw new IllegalArgumentException();
        }
    }

    public void inputRacingRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String round;
        round = inputRound();
        checkNullInputRound(round);
        round = deleteSpace(round);
        checkIntegerRound(round);
        checkZeroRound();
    }

    public String inputRound() {
        String round;
        round = Console.readLine();
        return round;
    }

    public void checkNullInputRound(String round) {
        if (round == null || round.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkIntegerRound(String round) {
        try {
            racingRound = Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    public void checkZeroRound() {
        if (racingRound == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void eachRound() {
        for (String key : cars.keySet()) {
            checkCarForward(key);
        }
        System.out.println();
    }

    public void checkCarForward(String key) {
        if (enableForward()) {
            cars.put(key, cars.get(key) + "-");
        }
        System.out.println(key + " : " + cars.get(key));
    }

    public boolean enableForward() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= 4;
    }

    public void allRound() {
        while (racingRound > 0) {
            eachRound();
            racingRound--;
        }
    }

    public void sortMap() {
        rank = new ArrayList<>(cars.keySet());
        rank.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return cars.get(o2).length() - cars.get(o1).length();
            }
        });
    }

    public void checkWinner(List<String> winner, String r) {
        if (cars.get(rank.get(0)).length() == cars.get(r).length()) {
            winner.add(r);
        }
    }

    public List<String> makeWinnerList() {
        List<String> winner = new ArrayList<>();
        for (String r : rank) {
            checkWinner(winner, r);
        }
        return winner;
    }

    public void printWinner() {
        sortMap();
        System.out.print("최종 우승자 : ");
        makeWinnerList();
        System.out.println(String.join(", ", makeWinnerList()));
    }

    public void run() {
        inputRacingCar();
        inputRacingRound();
        allRound();
        printWinner();
    }
}
