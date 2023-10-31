package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(){
        this.name = "";
        this.position = 0;
    }

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public String getName(){
        return name;
    }
    public int getPosition() {
        return position;
    }

    public void tryForwardChance(){
        int randomNumber = NumberGenerator.createRandomNumber();
        if(randomNumber >= 4){
            this.forward();
        }
    }

    private void forward(){
        this.position++;
    }

    public void printForawrdSituation(){
        StringBuilder output = new StringBuilder();
        output.append(name).append(" : ");
        for(int i = 0; i< position; i++){
            output.append("-");
        }
        output.append("\n");
        System.out.print(output.toString());
    }
}
