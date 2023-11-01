package racingcar;


import java.util.ArrayList;

public class Cars {
    public static String repeatCharacter(char character, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
        return builder.toString();
    }
    private final ArrayList<Car> cars;
    Cars(){
        cars=new ArrayList<>();
    }

    public void setCars(String[] splited){
        for (String name : splited) {
            if (name.length() > 5 || name.isEmpty())
                throw new IllegalArgumentException();
            this.cars.add(new Car(name));
        }
    }

    public void printLabs(int labs){
        for (int i=0;i<labs;i++){
            for(int j=0;j<cars.size();j++){
                System.out.println(cars.get(j).name+" : "+repeatCharacter('-',cars.get(j).drive_random()));
            }
            System.out.println();
        }
    }

    public ArrayList<Car> getWinners(){
        ArrayList<Car> winners=new ArrayList<>();
        int max=0;
        for (Car car : cars) {
            if (car.distance == max) {
                winners.add(car);
            }
            if (car.distance > max) {
                winners.clear();
                winners.add(car);
                max = car.distance;
            }
        }
        for (int i=0;i<winners.size();i++){
            System.out.print(winners.get(i).name);
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        return winners;
    }
}
