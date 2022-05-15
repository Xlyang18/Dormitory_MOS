package ALL_UI;

import NEW_Run.students_level;
import java.sql.SQLException;
import java.util.Scanner;

public class students_ui {

    // 获取输入的静态方法
    private static Scanner input = new Scanner(System.in);

    public static void start() throws SQLException, ClassNotFoundException {
        System.out.println("==========================");
        System.out.println("  \t<当前位置-学生界面首页>");
        System.out.println("==========================");
        System.out.println("  \t     仅用于少量权限");
        System.out.println("1、查看个人信息");
        System.out.println("2、查看寝室信息");
        System.out.println("3、修改个人密码");
        System.out.println("==========================");
        System.out.println("在此输入所需功能的编号（例如add1）：");
        String choose =  input.nextLine();
        switch (choose){
            case "1":
                students_level.function_one();
                break;
            case "2":
                students_level.function_two();
                break;
            case "3":
                students_level.function_three();
                break;
            default:
                System.out.println("输入有误请重新输入：");
                start();
        }
    }
}
