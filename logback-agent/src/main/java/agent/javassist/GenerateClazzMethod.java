package agent.javassist;

import javassist.*;
import javassist.bytecode.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenerateClazzMethod extends ClassLoader {


    public static String getParams(String className, String method) throws Exception {

        ClassPool pool = ClassPool.getDefault();

        // 获取类
        CtClass ctClass = pool.get(className);
//        ctClass.replaceClassName("ApiTest", "ApiTest02");
        String clazzName = ctClass.getName();

        // 获取方法
        CtMethod ctMethod = ctClass.getDeclaredMethod(method);
        String methodName = ctMethod.getName();

        // 方法信息：methodInfo.getDescriptor();
        MethodInfo methodInfo = ctMethod.getMethodInfo();

        // 方法：入参信息
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        CtClass[] parameterTypes = ctMethod.getParameterTypes();

        boolean isStatic = (methodInfo.getAccessFlags() & AccessFlag.STATIC) != 0;  // 判断是否为静态方法
        int parameterSize = isStatic ? attr.tableLength() : attr.tableLength() - 1; // 静态类型取值
        List<String> parameterNameList = new ArrayList<>(parameterSize);            // 入参名称
        List<String> parameterTypeList = new ArrayList<>(parameterSize);            // 入参类型
        StringBuilder parameters = new StringBuilder();                             // 参数组装；$1、$2...，$$可以获取全部，但是不能放到数组初始化

        for (int i = 0; i < parameterSize; i++) {
            parameterNameList.add(attr.variableName(i + (isStatic ? 0 : 1))); // 静态类型去掉第一个this参数
            parameterTypeList.add(parameterTypes[i].getName());
            if (i + 1 == parameterSize) {
                parameters.append("$").append(i + 1);
            } else {
                parameters.append("$").append(i + 1).append(",");
            }
        }

        System.out.println(parameters.toString());

        return parameters.toString();

    }
}
