package utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void fileWrite(StringBuffer sb, String fileName) {
        FileWriter writer = null;
        try {
            // 写入传入第二个参数指定的文件
            writer = new FileWriter(fileName, true);
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileWrite(StringBuffer sb) {
        System.out.println("### start file write now");
        String fileName = "F://default.log";
        fileWrite(sb, fileName);
    }

    public static void fileWrite(String str) {
        String fileName = "F://error.log";
        StringBuffer sb = new StringBuffer(str);
        fileWrite(sb, fileName);
    }
}
