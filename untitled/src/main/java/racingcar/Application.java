package racingcar;

import racingcar.Service.serviceSimulation;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException {

        serviceSimulation simulation = new serviceSimulation();
        simulation.run();
    }
}