package racingcar;

import racingcar.Service.serviceSimulation;


public class Application {
    public static void main(String[] args) {

        serviceSimulation simulation = new serviceSimulation();
        simulation.run();
    }
}