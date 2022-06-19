package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKTransactionProxy {

    public static Object getProxy(Object target) {
        return new JDKTransactionInvocationHandler(target).getProxy();
    }

    static class JDKTransactionInvocationHandler implements InvocationHandler {

        private Object target;

        public JDKTransactionInvocationHandler(Object target) {
            this.target = target;
        }

        public Object getProxy() {
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {
                System.out.println("transaction open");
                return method.invoke(target, args);
            } catch (Exception e) {
                System.out.println("transaction rollback");
                throw e;
            } finally {
                System.out.println("transaction close");
            }
        }
    }
}
