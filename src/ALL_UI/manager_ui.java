package ALL_UI;

import NEW_Run.manager_level;

import java.sql.SQLException;
import java.util.Scanner;

public class manager_ui {

    // 获取输入的静态方法
    private static Scanner input = new Scanner(System.in);

    public static void start() throws SQLException, ClassNotFoundException {
        System.out.println("==========================");
        System.out.println("  \t<当前位置-管理员界面首页>");
        System.out.println("==========================");
        System.out.println("  \t     开放全部功能权限");
        System.out.println("add增加模块");
        System.out.println("1、创建学生账号\t2、创建学生用户");
        System.out.println("del删除模块");
        System.out.println("1、删除学生信息\t2、删除学生账号");
        System.out.println("alter修改模块");
        System.out.println("1、修改学生账号\t2、分配学生寝室");
        System.out.println("find查询模块");
        System.out.println("1、查看全部账号\t2、查看全部学生");
        System.out.println("3、查看指定信息\t4、查看指定账号");
        System.out.println("5、查看楼栋信息");
        System.out.println("==========================");
        System.out.println("在此输入所需功能的编号（例如add1）：");
        String choose =  input.nextLine();
        switch (choose){
            case "add1":
                manager_level.add_students_user();
                break;

            case "add2":
                manager_level.add_students_students();
                break;

            case "del1":
                manager_level.del_students_students();
                break;

            case "del2":
                manager_level.del_students_user();
                break;

            case "alter1":
                manager_level.alter_students_user();
                break;


            case "alter2":
                manager_level.alter_students_dorm();
                break;

            case "find1":
                manager_level.find_students_user_all();
                break;

            case "find2":
                manager_level.find_students_students_all();
                break;

            case "find3":
                manager_level.find_students_students();
                break;

            case "find4":
                manager_level.find_students_user();
                break;


            case "find5":
                manager_level.find_dorm_all();
                break;

            default:
                System.out.println("输入有误请重新输入：");
                start();

        }
    }
}
