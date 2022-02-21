package agent.transformer;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import utils.FileUtil;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTransformer implements ClassFileTransformer {

    public static String METHOD_NAME = "";
    public static String CLASS_NAME = "";



    // 被处理的方法列表
    final static Map<String, List<String>> methodMap = new HashMap<String, List<String>>();

    public MyTransformer() {
        add("org.apache.ibatis.binding.MapperMethod");
//        add("com.example.logback.application.service.LogService");
    }

    private void add(String methodString) {
        String className = methodString.substring(0, methodString.lastIndexOf("."));
        String methodName = methodString.substring(methodString.lastIndexOf(".") + 1);
        List<String> list = methodMap.get(className);
        if (list == null) {
            list = new ArrayList<String>();
            methodMap.put(className, list);
        }
        list.add(methodName);
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        ClassPool pool = ClassPool.getDefault();
        String classNameHere = className.replace("/", ".");
        System.out.println(classNameHere);
        try {
            if (classNameHere.equals(CLASS_NAME)) {
                // 获取类
                CtClass ctClass = null;
                String className2 = classNameHere.replace("$", ".");
                ctClass = pool.get(className2);

                System.out.println("==========" + className);

                // 获取方法
                CtMethod ctMethod = ctClass.getDeclaredMethod(METHOD_NAME);

                System.out.println("!!!!!" + ctMethod.getName());

                // 方法信息：methodInfo.getDescriptor();
                MethodInfo methodInfo = ctMethod.getMethodInfo();

                System.out.println("!!!!!" + methodInfo.getDescriptor());

                // 方法：入参信息
                CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
                LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
                CtClass[] parameterTypes = ctMethod.getParameterTypes();

                boolean isStatic = (methodInfo.getAccessFlags() & AccessFlag.STATIC) != 0;  // 判断是否为静态方法
                if (isStatic) {
                    System.out.println("!!! Is static");
                } else {
                    System.out.println("!!! Is Not static");
                }
                int parameterSize = isStatic ? attr.tableLength() : attr.tableLength() - 1; // 静态类型取值
                System.out.printf("!!! parameter size: %d\n", parameterSize);

                List<String> parameterNameList = new ArrayList<>(parameterSize);            // 入参名称
                List<String> parameterTypeList = new ArrayList<>(parameterSize);            // 入参类型
                StringBuffer parameters = new StringBuffer();                             // 参数组装；$1、$2...，$$可以获取全部，但是不能放到数组初始化

                for (int i = 0; i < parameterSize; i++) {
                    parameterNameList.add(attr.variableName(i + (isStatic ? 0 : 1))); // 静态类型去掉第一个this参数
                    parameterTypeList.add(parameterTypes[i].getName());
                    if (i + 1 == parameterSize) {
                        parameters.append("$").append(i + 1);
                    } else {
                        parameters.append("$").append(i + 1).append(",");
                    }
                }
                System.out.println("----------" + parameterNameList);
                System.out.println("----------" + parameterTypeList);
                System.out.println("----------" + parameters.toString());
                FileUtil.fileWrite(parameters);
            }

        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
