package racingcar.model;

public class Car {
    private String name;
    private int status;

    public Car(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public void move() {
        status++;
    }

   public String getStatus() {
        String statusString = "";
        for (int i=0;i<status;i++) {
            statusString += "-";
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(name).append(" : ").append(statusString).toString();
   }
}