package MANAGER;

import java.sql.*;
import java.util.Scanner;


// 特殊批注：executeQuery是查询操作的运行，而增删改insert/update/delete都是更新操作的运行executeUpdate()


public class manager {
    private static Scanner input = new Scanner(System.in);

    // 选择是否继续操作
    public static void choose() throws SQLException, ClassNotFoundException {
        System.out.println("输入继续进行操作？Y/N");
        String choose = input.nextLine();
        switch (choose){
            case "Y":
                command_UI_manager.start();
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
        System.out.println("在此输入所需功能的编号：");
        String choose = input.nextLine();
        switch (choose) {
            case "1":
                command_UI_manager.no_1();
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("MySQL连接驱动加载成功");
                Connection connect_1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
                System.out.println("MySQL连接成功");
                Statement statement_1 = connect_1.createStatement();
                System.out.print("在此输入需要添加的账号用户名：");
                String one_uname = input.nextLine();
                System.out.print("请继续输入该学生账号的密码：");
                String one_upass = input.nextLine();
                statement_1.executeUpdate("INSERT INTO `user` SET uname=\""+one_uname+"\",upass=\""+one_upass+"\",type=2");
                // 特殊批注：executeQuery是查询操作的运行，而增删改insert/update/delete都是更新操作的运行executeUpdate()
                System.out.println("操作完成");

                System.out.println("==========================");
                choose();
                break;
            case "2":
                command_UI_manager.no_2();
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("MySQL连接驱动加载成功");
                Connection connect_2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
                System.out.println("MySQL连接成功");
                Statement statement_2 = connect_2.createStatement();
                System.out.print("所属学院：");
                String one_faculty = input.nextLine();
                System.out.print("所在班级：");
                String one_class = input.nextLine();
                System.out.print("学生学号");
                String one_id = input.nextLine();
                System.out.print("学生姓名：");
                String one_name = input.nextLine();
                System.out.print("学生性别：");
                String one_sex = input.nextLine();
                statement_2.executeUpdate("INSERT INTO students(faculty,class,id,name,sex,building,room) " +
                        "VALUE(\""+one_faculty+"\",\""+one_class+"\","+one_id+",\""+one_name+"\",\""+one_sex+"\",\"building\",\"room\")");

                System.out.println("操作完成");

                System.out.println("==========================");
                choose();
                break;
            case "3":
                command_UI_manager.no_3();
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("MySQL连接驱动加载成功");
                Connection connect_3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
                System.out.println("MySQL连接成功");
                Statement statement_3 = connect_3.createStatement();
                System.out.print("输入需要删除的学生姓名：");
                String dele_name = input.nextLine();
                statement_3.executeUpdate("DELETE FROM students WHERE name=\""+dele_name+"\"");
                System.out.println("操作完成");

                System.out.println("==========================");
                choose();
                break;
            case "4":
                command_UI_manager.no_4();
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("MySQL连接驱动加载成功");
                Connection connect_4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
                System.out.println("MySQL连接成功");
                Statement statement_4 = connect_4.createStatement();
                System.out.print("输入需要修改的学生账号：");
                String one_uname_4 = input.nextLine();
                System.out.println("输入该账号的新密码：");
                String one_upass_4 = input.nextLine();
                statement_4.executeUpdate("UPDATE user SET upass=\""+one_upass_4+"\" WHERE uname=\""+one_uname_4+"\"");
                System.out.println("操作完成");

                System.out.println("==========================");
                choose();
                break;
            case "5":
                command_UI_manager.no_5();
                Class.forName("com.mysql.jdbc.Driver");
//                System.out.println("MySQL连接驱动加载成功");
                Connection connect_5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
//                System.out.println("MySQL连接成功");

                Statement statement_5 = connect_5.createStatement();
                ResultSet result_5 = statement_5.executeQuery("SELECT * FROM `students`");
                while (result_5.next()) {
                    System.out.print(result_5.getString("faculty") + " "); //学院
                    System.out.print(result_5.getString("class") + " ");  //班级
                    System.out.print(result_5.getInt("id") + " ");  // 学号（序号）
                    System.out.print(result_5.getString("name") + " ");  // 姓名
                    System.out.print(result_5.getString("sex") + " ");  // 性别
                    System.out.print(result_5.getString("building") + " ");  // 楼栋
                    System.out.println(result_5.getString("room"));  // 房间号

                }
                System.out.println("==========================");
                choose();
                break;
            case "6":
                command_UI_manager.no_6();
                Class.forName("com.mysql.jdbc.Driver");
//                System.out.println("MySQL连接驱动加载成功");
                Connection connect_6 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
//                System.out.println("MySQL连接成功");

                System.out.println("请输入学生名：");
                String one_name_6 = input.nextLine();

                Statement statement_6 = connect_6.createStatement();
                ResultSet result_6 = statement_6.executeQuery("select * from students where name=\""+one_name_6+"\"");
                while (result_6.next()) {
                    System.out.print(result_6.getString("faculty") + " "); //学院
                    System.out.print(result_6.getString("class") + " ");  //班级
                    System.out.print(result_6.getInt("id") + " ");  // 学号（序号）
                    System.out.print(result_6.getString("name") + " ");  // 姓名
                    System.out.print(result_6.getString("sex") + " ");  // 性别
                    System.out.print(result_6.getString("building") + " ");  // 楼栋
                    System.out.println(result_6.getString("room"));  // 房间号

                }
                System.out.println("==========================");
                choose();
                break;
            case "7":
                command_UI_manager.no_7();
                Class.forName("com.mysql.jdbc.Driver");
//                System.out.println("MySQL连接驱动加载成功");
                Connection connect_7 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
//                System.out.println("MySQL连接成功");

                Statement statement_7 = connect_7.createStatement();
                ResultSet result_7 = statement_7.executeQuery("SELECT * FROM `user`");
                while (result_7.next()) {
                    System.out.print(result_7.getString("uname") + " "); //账号
                    System.out.print(result_7.getString("upass") + " ");  //密码
                    System.out.println(result_7.getInt("type") + " ");  // Type判断值

                }
                System.out.println("==========================");
                choose();
                break;
            case "8":
                command_UI_manager.no_8();
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("MySQL连接驱动加载成功");
                Connection connect_8 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
                System.out.println("MySQL连接成功");
                Statement statement_8 = connect_8.createStatement();
                System.out.print("输入需要查看的学生账号：");
                String one_uname_8 = input.nextLine();
                ResultSet result_8 = statement_8.executeQuery("select * from user where uname=\""+one_uname_8+"\"\n");
                System.out.println("操作完成");
                System.out.println("==========================");
                while (result_8.next()) {
                    System.out.print(result_8.getString("uname") + " "); //账号
                    System.out.print(result_8.getString("upass") + " ");  //密码
                    System.out.println(result_8.getInt("type") + " ");  // Type判断值

                }
                System.out.println("==========================");
                choose();
                break;
            case "9":
                command_UI_manager.no_9();
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("MySQL连接驱动加载成功");
                Connection connect_9 = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
                System.out.println("MySQL连接成功");
                Statement statement_9 = connect_9.createStatement();
                System.out.print("输入学生姓名信息：");
                String one_name_9 = input.nextLine();
                System.out.println("分配楼栋：");
                String one_building_9 = input.nextLine();
                System.out.println("分配寝室号：");
                String one_room_9 = input.nextLine();
                statement_9.executeUpdate("UPDATE students SET building=\""+one_building_9+"\",room=\""+one_room_9+"\" WHERE name=\""+one_name_9+"\"\n");
                System.out.println("操作完成");

                System.out.println("==========================");
                choose();
                break;
            default:
                System.out.println("输入有误，请重新输入");

        }


    }
}
