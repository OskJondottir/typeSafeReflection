package osk.jonsdottir.reflection;

import static org.mockito.Mockito.mock;

import java.lang.reflect.Method;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class Inspector {
    private static ThreadLocal<Method> lastMethodCalled = new ThreadLocal<Method>();

    public static <T> Method method(T methodCallReturnedValue) {
        Method m = lastMethodCalled.get();
        if (m == null) {
            throw new IllegalArgumentException("method() was passed an argument that was not the result of a method invocation on an inspected object");
        }
        lastMethodCalled.set(null);
        return m;
    }

    @SuppressWarnings("unchecked")
    public static <T> T inspect(T o) {
        return inspect((Class<T>)o.getClass());
    }
    
    public static <T> T inspect(Class<T> o) {
        lastMethodCalled.set(null);
        T oMock = (T)mock(o, new Answer<Object>() {
            public Object answer(InvocationOnMock invocation) throws Throwable {
                lastMethodCalled.set(invocation.getMethod());
                return null;
            }
        });
        return oMock;
    }
}
