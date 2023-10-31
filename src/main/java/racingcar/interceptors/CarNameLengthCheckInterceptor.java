package racingcar.interceptors;

import java.util.List;

public class CarNameLengthCheckInterceptor implements Interceptor<List<String>, List<String>> {
    @Override
    public List<String> handling(List<String> targetObjects) throws IllegalArgumentException {
        for (String targetObject : targetObjects) {
            if (targetObject.isEmpty() || targetObject.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return targetObjects;
    }
}
