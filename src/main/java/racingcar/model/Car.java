package racingcar.model;

public class Car {
    private String name;
    private Integer status;
    private static final Integer INITIAL_STATUS = 0;

    private Car(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public static Car makeCar(String name) {
        return new Car(name, INITIAL_STATUS);
    }

    public void move() {
        status++;
    }

   public String getStatusString() {
        String statusString = "";
        for (int i=0;i<status;i++) {
            statusString += "-";
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(name).append(" : ").append(statusString).toString();
   }

   public int getStatus() {
        return status;
   }

    public String getName() {
        return name;
    }
}