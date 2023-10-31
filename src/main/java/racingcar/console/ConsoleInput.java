package racingcar.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.interceptors.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class ConsoleInput<T, K> {
    private final Interceptor<String, T> init;
    private List<Interceptor<T, T>> interceptors = new ArrayList<>();
    private final Interceptor<T, K> finalize;

    public ConsoleInput(Interceptor<String, T> init, Interceptor<T, K> finalize) {
        this.init = init;
        this.finalize = finalize;
    }

    public ConsoleInput(Interceptor<String, T> init, List<Interceptor<T, T>> interceptors, Interceptor<T, K> finalize) {
        this.init = init;
        this.interceptors = interceptors;
        this.finalize = finalize;
    }

    public K getUserInput(String inputMessage) {
        System.out.println(inputMessage);

        String input = Console.readLine();

        T targetObject = init.handling(input);

        for (Interceptor<T, T> interceptor : interceptors) {
            targetObject = interceptor.handling(targetObject);
        }

        return finalize.handling(targetObject);
    }

    public ConsoleInput<T, K> registerInterceptor(Interceptor<T, T> interceptor) {
        interceptors.add(interceptor);
        return this;
    }

    public boolean unregisterInterceptor(Interceptor<T, T> interceptor) {
        return interceptors.remove(interceptor);
    }
}
