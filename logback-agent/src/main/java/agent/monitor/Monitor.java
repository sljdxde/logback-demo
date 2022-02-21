package agent.monitor;

import application.LogService;
import commend.LogCommend;
import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class Monitor {

    @RuntimeType
    public static Object intercept(@Origin Method method, @AllArguments Object[] args, @Argument(0) Object arg0, @SuperCall Callable<?> callable) throws Exception {
        Object resObj = null;
        try {
            LogCommend logCommend = new LogCommend(arg0, method.getName());
            LogService logService = new LogService();
            logService.save(logCommend);

            print(method, arg0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resObj;
    }


    private static void print(Method method, Object arg0) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("方法名称：").append(method.getName()).append("\n");
//        sb.append("入参个数：").append(method.getParameterCount()).append("\n");
//        sb.append("入参内容：").append(arg0).append("\n");
        System.out.println("方法名称：" + method.getName());
        System.out.println("入参个数：" + method.getParameterCount());
        System.out.println("入参内容：" + arg0);
    }



}
