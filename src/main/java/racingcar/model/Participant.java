package racingcar.model;

public class Participant {
    private String name;
    private int stepOfForward;

    public Participant(String name, int stepOfForward){
        this.name = name;
        this.stepOfForward = stepOfForward;
    }

    public String getName() {
        return name;
    }

    public int getStepOfForward() {
        return stepOfForward;
    }

    public void plus(){
        this.stepOfForward += 1;
    }
}
