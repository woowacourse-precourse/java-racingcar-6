package racingcar;

public class Car {

    private String name;
    private final StringBuilder position = new StringBuilder();

    public Car(String name) {

        this.name = name;

    }

    public String moveForward() {

        this.position.append("-");

        return this.position.toString();
    }

    public String stop() {

        return this.position.toString();

    }

    public void choiceActive() {
        OneDigitRandomNumber randomNumber = new OneDigitRandomNumber();

        if (randomNumber.judgmentFourOrMore()) {

            System.out.println(this.name + " : " + this.moveForward());

        } else {

            System.out.println(this.name + " : " + this.stop());

        }
    }
}
