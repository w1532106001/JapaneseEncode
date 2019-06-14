import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * @Author: WHC
 * @Date: 2019/5/19 19:58
 * @description
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入需要转码的文件夹地址");
        changeName(in.next());
        System.out.println("转换完成");

    }
    public static  void changeName(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = null;
            try {
                String path2 = files[i].getPath().substring(0,files[i].getPath().lastIndexOf("\\"));
                name = path2+File.separatorChar+ new String(files[i].getName().getBytes("gbk"),"shift-jis");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(name);
            files[i].renameTo(new File(name));
            if(files[i].isDirectory()){
                changeName(files[i].toString());
            }
        }
    }
//    public static  void  change(String path){
//        File file = new File(path);
//        String name = null;
//        try {
//            String path2 = file.getPath().substring(0,file.getPath().lastIndexOf("\\"));
//            name = path2+File.separatorChar+ new String(file.getName().getBytes("gbk"),"shift-jis");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        file.renameTo(new File(name));
//        changeName(file.getPath());
//    }
}
