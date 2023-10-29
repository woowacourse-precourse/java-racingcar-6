package racingcar;

public class Car {
    private String name;
    private Integer position;

    public Car(String name, Integer position) {
        checkCarNameLength(name);
        this.name = name;
        this.position = position;
    }

    public void checkCarNameLength(String carName){
        if(carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void move(Integer randomNumber){
        if(randomNumber >= 4)
            this.position++;
    }

    public void printStatus(){
        System.out.print(this.name + " : ");
        for(int i=0; i<this.position; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
