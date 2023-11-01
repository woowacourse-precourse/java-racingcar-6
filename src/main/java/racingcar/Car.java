package racingcar;

public class Car implements Comparable {
    private String name;
    private int location;
    public Car(String name){
        if(!(name.length()<5)){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다");
        }
        this.name = name;
        this.location = 0;
    }
    public String getName(){
        return name;
    }
    public int getLocation(){
        return location;
    }
    public void proceed(){
        location += 1;
    }
    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < location; i++) {
            sb.append('-');
        }
        System.out.println(sb);
    }


    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.location, ((Car)o).location);
    }
}
