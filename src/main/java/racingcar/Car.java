package racingcar;

public class Car {
    private String name;
    private int forwardCount = 0;
    private static final String FORWARD_MESSAGE = "-";

    Car (String name) {
        this.name = name;
    }

    void forward(int step) {
        forwardCount+= step;
    }

    void printForwardState() {
        StringBuilder printMessage = new StringBuilder();
        printMessage.append(name + " : ");
        for(int i = 0; i < forwardCount; i++) {
            printMessage.append(FORWARD_MESSAGE);
        }
        System.out.println(printMessage);
    }
}
