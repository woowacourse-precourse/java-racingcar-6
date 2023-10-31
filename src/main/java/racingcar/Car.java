package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name = "";
    private Integer position = -1;
    private Numbers numbers;
    public Car(String name) {
        this.name = name;
        this.numbers = new Numbers();
    }

    public void printMoves() {
        System.out.println(this.name + " : " + "-".repeat(this.position));
    }

    public void trial() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        this.position += this.numbers.compareFour(randomNumber);
    }

    public String getName() {return this.name;}

    public int getPosition() {return this.position;}
}
