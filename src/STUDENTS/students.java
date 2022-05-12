package STUDENTS;

import MANAGER.command_UI_manager;

import java.sql.*;
import java.util.Scanner;

public class students {

    private static Scanner input = new Scanner(System.in);

    public static void choose() throws SQLException, ClassNotFoundException {
        System.out.println("输入继续进行操作？Y/N");
        String choose = input.nextLine();
        switch (choose){
            case "Y":
                command_UI_student.start();
                main(null);
                break;
            case "N":
                System.out.println("==========================");
                System.out.println("正在退出系统");
                System.out.println("==========================");
                System.out.println("系统已成功退出");
                System.out.println("==========================");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.print("在此输入所需功能的编号：");
        String choose =  input.nextLine();
        switch (choose){
            case "1":
                command_UI_student.no_1();
                Class.forName("com.mysql.jdbc.Driver");
//                System.out.println("MySQL连接驱动加载成功");
                Connection connect_1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
//                System.out.println("MySQL连接成功");

                System.out.println("请输入本人学号用于核实身份：");
                String one_id_1 = input.nextLine();

                Statement statement_1 = connect_1.createStatement();
                ResultSet result_1 = statement_1.executeQuery("select * from students where id=\""+one_id_1+"\"");
                while (result_1.next()) {
                    System.out.print(result_1.getString("faculty") + " "); //学院
                    System.out.print(result_1.getString("class") + " ");  //班级
                    System.out.print(result_1.getInt("id") + " ");  // 学号（序号）
                    System.out.print(result_1.getString("name") + " ");  // 姓名
                    System.out.println(result_1.getString("sex") + " ");  // 性别

                }
                System.out.println("==========================");
                choose();
                break;
            case "2":
                command_UI_student.no_2();
                Class.forName("com.mysql.jdbc.Driver");
//                System.out.println("MySQL连接驱动加载成功");
                Connection connect_2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
//                System.out.println("MySQL连接成功");

                System.out.println("请输入本人学号用于核实身份：");
                String one_id_2 = input.nextLine();

                Statement statement_2 = connect_2.createStatement();
                ResultSet result_2 = statement_2.executeQuery("select * from students where id=\""+one_id_2+"\"");

                while (result_2.next()) {
                    System.out.print(result_2.getInt("id") + " ");  // 学号（序号）
                    System.out.print(result_2.getString("name") + " ");  // 姓名
                    System.out.print(result_2.getString("building") + " ");  // 楼栋
                    System.out.println(result_2.getString("room"));  // 房间号

                }
                System.out.println("==========================");
                choose();
                break;
            case "3":
                command_UI_student.no_3();
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("MySQL连接驱动加载成功");
                Connection connect_3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
                System.out.println("MySQL连接成功");
                Statement statement_3 = connect_3.createStatement();
                System.out.print("再次输入账号：");
                String one_uname_3 = input.nextLine();
                System.out.println("输入该账号的新密码：");
                String one_upass_3 = input.nextLine();
                statement_3.executeUpdate("UPDATE user SET upass=\""+one_upass_3+"\" WHERE uname=\""+one_uname_3+"\"");
                System.out.println("操作完成");

                System.out.println("==========================");
                choose();
                break;
            default:
                System.out.println("输入有误，请重新输入");
                main(null);

        }


    }
}
