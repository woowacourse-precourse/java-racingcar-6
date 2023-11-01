package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final UserInput userInput;
    private List<Car> carList = new ArrayList<>();

    public Cars(UserInput userInput) {
        this.userInput = userInput;

        String[] carArray = userInput.getCarArray();

        for (int i = 0; i < carArray.length; i++) {
            carList.add(new Car(carArray[i]));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public class Car {
        private String name;
        private String drawingMovement;
        private int numberOfMoves;

        public Car(String name) {
            this.name = name;
            this.drawingMovement = "";
            this.numberOfMoves = 0;
        }

        public String getName() {
            return name;
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
    }
}
