package racingcar.domain;

public class Car {
    String name;
    String result;

    public String getAnswer() {
        return answer;
    }

    String answer;

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    public Car(String name) {
        this.name = name;
        this.result = name + " : ";
        this.answer = name + ", ";
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
