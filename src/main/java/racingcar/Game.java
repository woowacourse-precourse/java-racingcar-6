package racingcar;

import java.util.List;

public class Game {
    public void start() {
        PrintHandler.inputCarNamesPrompt();
        List<String> carNamesWithoutSeparator = InputHandler.carNames();
        List<Car> cars = CarFactory.createCars(carNamesWithoutSeparator);

        PrintHandler.inputTrialNumberPrompt();
        int trialNum = InputHandler.tryNumber();

        PrintHandler.resultRunningSentence();
        threadsStartIterator(cars, trialNum);
    }

    private void threadsStart(List<Thread> carThreads) {
        for (Thread thread : carThreads) {
            thread.start();
        }
    }

    private void threadsStartIterator(List<Car> cars, int trialNum) {
        for (int i = 0; i < trialNum; i++) {
            List<Thread> carThreads = ThreadManager.addThread(cars);
            threadsStart(carThreads);
            threadsJoinIterator(carThreads);
            PrintHandler.resultRunning(cars);
        }
    }

    private void threadsJoinIterator(List<Thread> carThreads) {
        for (Thread thread : carThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}
