package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;
    private NumberCondition numberCondition = new NumberCondition();
    public Car(String name) { this.name = name; }

    public void printMoves() {
        System.out.println(this.name + " : " + "-".repeat(this.position));
    }

    public void trial() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        this.position += this.numberCondition.compareFour(randomNumber);
    }

    public String getName() { return this.name; }

    public int getPosition() { return this.position; }
}
