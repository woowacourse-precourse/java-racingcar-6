package racingcar.domain;

public class Car {
    String name;
    String result;
    String resultNumber;

    public Car(String name) {
        this.name = name;
        this.result = name + " : ";
    }

    public void addResult(){
        result += "-";
    }

    public void printName(){
        System.out.println(name);
    }

    public void printResult(){
        System.out.println(result);
    }
}
