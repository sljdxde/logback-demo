package agent;

import agent.monitor.Monitor;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class MyAgent {

    public static void premain(String arguments, Instrumentation instrumentation) throws ClassNotFoundException {
        System.out.println("当前配置参数信息为：" + arguments);
        String[] toArray = arguments.split(",");

        // ElementMatchers.nameStartsWith("com.example.logback.domain")

        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith(toArray[0]))
                .transform((builder, typeDescription, classLoader, javaModule) -> builder
                        .method(ElementMatchers.any())
                        .intercept(MethodDelegation.to(Monitor.class)))
                .installOn(instrumentation);


    }
}
