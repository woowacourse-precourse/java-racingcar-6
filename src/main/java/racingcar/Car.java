package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public void setName(String name) {
        if(name.length() > 5 || name.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addPosition(int n){
        this.position = this.position + n;
    }

    public int getPosition(){
        return this.position;
    }
}
