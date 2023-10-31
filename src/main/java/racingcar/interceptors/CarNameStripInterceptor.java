package racingcar.interceptors;

import java.util.List;

public class CarNameStripInterceptor implements Interceptor<List<String>, List<String>> {
    @Override
    public List<String> handling(List<String> targetObjects) throws IllegalArgumentException {
        return targetObjects
                .stream()
                .map(String::strip)
                .toList();
    }
}
