package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Comparable<RacingCar> {
    private String name;
    private Integer movedDistance;

    public String getName() {
        return name;
    }

    public RacingCar(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("RacingCar name length error");
        }
        this.name = name;
        this.movedDistance = 0;
    }

    public void tryMoving() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            movedDistance += 1;
        }
    }

    public void printResult() {
        System.out.print(name + " : ");
        for (int i = 0; i < movedDistance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public Integer getMovedDistance() {
        return movedDistance;
    }

    @Override
    public int compareTo(RacingCar o) {
        return o.movedDistance - movedDistance;
    }
}
