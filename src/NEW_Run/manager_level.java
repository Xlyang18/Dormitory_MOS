package NEW_Run;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static NEW_Run.run.run_jdbc;

/*
* 管理员模块功能梳理：
* 增加：创建学生账号（1）、创建学生用户（2）、
* 删除：删除学生信息（3）、删除学生账号（ok）
* 修改：修改学生账号（4）、分配学生宿舍（9）
* 查询：查看全部账号（7）、查看全部学生（5）、查看指定信息（6）、
*      查看指定账号（8）、查看楼栋信息（ok）

* */
public class manager_level {

    private static Scanner input = new Scanner(System.in);

    public static void choose() throws SQLException, ClassNotFoundException {
        System.out.println("输入继续进行操作？Y/N");
        String choose = input.nextLine();
        switch (choose){
            case "Y":
                ALL_UI.manager_ui.start();
                break;
            case "N":
                System.out.println("==========================");
                System.out.println("正在退出系统");
                System.out.println("==========================");
                System.out.println("系统已成功退出");
                System.out.println("==========================");
        }
    }


    public static void add_students_user() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.print("在此输入需要添加的账号用户名：");
        String one_uname = input.nextLine();
        System.out.print("请继续输入该学生账号的密码：");
        String one_upass = input.nextLine();
        statement.executeUpdate("INSERT INTO `user` SET uname=\""+one_uname+"\",upass=\""+one_upass+"\",type=2");
        // 特殊批注：executeQuery是查询操作的运行，而增删改insert/update/delete都是更新操作的运行executeUpdate()
        System.out.println("操作完成");

        System.out.println("==========================");
        choose();
    }

    public static void add_students_students() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
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
        statement.executeUpdate("INSERT INTO students(faculty,class,id,name,sex,building,room) " +
                "VALUE(\""+one_faculty+"\",\""+one_class+"\","+one_id+",\""+one_name+"\",\""+one_sex+"\",\"building\",\"room\")");

        System.out.println("操作完成");

        System.out.println("==========================");
        choose();
    }

    public static void del_students_students() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.print("输入需要删除的学生姓名：");
        String dele_name = input.nextLine();
        statement.executeUpdate("DELETE FROM students WHERE name=\""+dele_name+"\"");
        System.out.println("操作完成");

        System.out.println("==========================");
        choose();
    }

    public static void del_students_user() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.print("输入需要删除的学生账号：");
        String dele_uname = input.nextLine();
        statement.executeUpdate("DELETE FROM user WHERE name=\""+dele_uname+"\"");
        System.out.println("操作完成");

        System.out.println("==========================");
        choose();
    }

    public static void alter_students_user() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.print("输入需要修改的学生账号：");
        String one_uname_4 = input.nextLine();
        System.out.println("输入该账号的新密码：");
        String one_upass_4 = input.nextLine();
        statement.executeUpdate("UPDATE user SET upass=\""+one_upass_4+"\" WHERE uname=\""+one_uname_4+"\"");
        System.out.println("操作完成");

        System.out.println("==========================");
        choose();
    }

    public static void alter_students_students() {
    }

    public static void alter_students_dorm() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.print("输入学生姓名信息：");
        String one_name_9 = input.nextLine();
        System.out.println("分配楼栋：");
        String one_building_9 = input.nextLine();
        System.out.println("分配寝室号：");
        String one_room_9 = input.nextLine();
        statement.executeUpdate("UPDATE students SET building=\""+one_building_9+"\",room=\""+one_room_9+"\" WHERE name=\""+one_name_9+"\"\n");
        System.out.println("操作完成");

        System.out.println("==========================");
        choose();
    }

    public static void find_students_user_all() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        ResultSet result_7 = statement.executeQuery("SELECT * FROM `user`");
        while (result_7.next()) {
            System.out.print(result_7.getString("uname") + " "); //账号
            System.out.print(result_7.getString("upass") + " ");  //密码
            System.out.println(result_7.getInt("type") + " ");  // Type判断值

        }
        System.out.println("==========================");
        choose();
    }

    public static void find_students_students_all() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        ResultSet result_5 = statement.executeQuery("SELECT * FROM `students`");
        while (result_5.next()) {
            System.out.print(result_5.getString("faculty") + " "); //学院
            System.out.print(result_5.getString("class") + " ");  //班级
            System.out.print(result_5.getInt("id") + " ");  // 学号（序号）
            System.out.print(result_5.getString("name") + " ");  // 姓名
            System.out.print(result_5.getString("sex") + " ");  // 性别
            System.out.print(result_5.getString("building") + " ");  // 楼栋
            System.out.println(result_5.getString("room"));  // 房间号
            System.out.println("==========================");
        }
        choose();
    }

    public static void find_students_students() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.println("请输入学生名：");
        String one_name_6 = input.nextLine();
        ResultSet result_6 = statement.executeQuery("select * from students where name=\"" + one_name_6 + "\"");
        while (result_6.next()) {
            System.out.print(result_6.getString("faculty") + " "); //学院
            System.out.print(result_6.getString("class") + " ");  //班级
            System.out.print(result_6.getInt("id") + " ");  // 学号（序号）
            System.out.print(result_6.getString("name") + " ");  // 姓名
            System.out.print(result_6.getString("sex") + " ");  // 性别
            System.out.print(result_6.getString("building") + " ");  // 楼栋
            System.out.println(result_6.getString("room"));  // 房间号
            System.out.println("==========================");
        }
        choose();

    }


    public static void find_students_user() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.print("输入需要查看的学生账号：");
        String one_uname_8 = input.nextLine();
        ResultSet result_8 = statement.executeQuery("select * from user where uname=\""+one_uname_8+"\"\n");
        System.out.println("操作完成");
        System.out.println("==========================");
        while (result_8.next()) {
            System.out.print(result_8.getString("uname") + " "); //账号
            System.out.print(result_8.getString("upass") + " ");  //密码
            System.out.println(result_8.getInt("type") + " ");  // Type判断值

        }
        System.out.println("==========================");
        choose();
    }


    public static void find_dorm_all() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        ResultSet result_8 = statement.executeQuery("select * from dorm");
        System.out.println("操作完成");
        System.out.println("==========================");
        while (result_8.next()) {
            System.out.print(result_8.getString("LouDong") + " ");
            System.out.print(result_8.getInt("level") + " ");
            System.out.println(result_8.getInt("area") + " ");
            System.out.println(result_8.getInt("num_student") + " ");
            System.out.println(result_8.getInt("num_now") + " ");
        }
        System.out.println("==========================");
        choose();
    }

}
