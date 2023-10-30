package racingcar.domain;

public class Car {
    private final String name;
    private final StringBuilder trace = new StringBuilder();
    private int score = 0;
    public Car(String name){
        this.name = name;
    }

    public void move(){
        score++;
        trace.append("-");
        System.out.println(name+" : "+trace);
    }

    public void stop(){
        System.out.println(name+" : "+trace);
    }

    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }
}
