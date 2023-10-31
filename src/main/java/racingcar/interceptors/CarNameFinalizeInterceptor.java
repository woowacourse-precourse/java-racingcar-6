package racingcar.interceptors;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CarNameFinalizeInterceptor implements Interceptor<List<String>, Map<String, String>> {
    @Override
    public Map<String, String> handling(List<String> targetObject) throws IllegalArgumentException {
        return targetObject.stream().collect(toMap(Object::toString, data -> ""));
    }
}
