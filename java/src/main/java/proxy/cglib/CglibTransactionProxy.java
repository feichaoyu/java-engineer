package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTransactionProxy {

    public static Object getProxy(Object target) {
        return Enhancer.create(target.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("transaction open");
                Object result;
                try {
                    // 正确
                    result = methodProxy.invokeSuper(o, args);
                    result = methodProxy.invoke(target, args);

                    // 错误
//                    result = methodProxy.invokeSuper(target, args);
//                    result = methodProxy.invoke(o, args);
                    return result;
                } catch (Exception e) {
                    System.out.println("transaction rollback");
                    throw e;
                } finally {
                    System.out.println("transaction close");
                }

            }
        });
    }
}
