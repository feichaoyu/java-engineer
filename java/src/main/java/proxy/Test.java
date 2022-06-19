package proxy;

import proxy.cglib.CglibTransactionProxy;
import proxy.jdk.JDKTransactionProxy;
import proxy.service.UserService;
import proxy.service.UserServiceImpl;

import java.io.File;

import static net.sf.cglib.core.DebuggingClassWriter.DEBUG_LOCATION_PROPERTY;

public class Test {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserService userService = new UserServiceImpl();
        UserService proxy = (UserService) JDKTransactionProxy.getProxy(userService);
        proxy.login();

        System.setProperty(DEBUG_LOCATION_PROPERTY, new File("").getAbsolutePath() + "/cglib");
        UserService userService2 = new UserServiceImpl();
        UserService proxy2 = (UserService) CglibTransactionProxy.getProxy(userService2);
        proxy2.login();
    }
}
