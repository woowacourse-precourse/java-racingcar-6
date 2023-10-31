package car;

public class Car {
    private String name;

    private int count;

    public Car(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getCount(){
        return count;
    }

    public void move(int readNumber){
        if(readNumber >= 4){
            count++;
        }
    }

    public void printResult(){
        String printCount = "";
        for(int i = 0; i < count; i++){
            printCount += "-";
        }
        System.out.println(name + " : " + printCount);
    }

}
