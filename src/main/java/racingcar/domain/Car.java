package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private String drawingMovement;
    private int numberOfMoves;

    private List<Car> carList = new ArrayList<>();

    public Car(String name) {
        this.name = name;
        this.drawingMovement = "";
        this.numberOfMoves = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrawingMovement() {
        return drawingMovement;
    }

    public void setDrawingMovement(String drawingMovement) {
        this.drawingMovement = drawingMovement;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public void setCarList(String namesString) {

    }
}
