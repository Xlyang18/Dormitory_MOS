package NEW_Run;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static NEW_Run.run.run_jdbc;



public class students_level {

    private static Scanner input = new Scanner(System.in);

    public static void function_one() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.println("请输入本人学号用于核实身份：");
        String one_id_1 = input.nextLine();

        ResultSet result_1 = statement.executeQuery("select * from students where id=\""+one_id_1+"\"");
        while (result_1.next()) {
            System.out.print(result_1.getString("faculty") + " "); //学院
            System.out.print(result_1.getString("class") + " ");  //班级
            System.out.print(result_1.getInt("id") + " ");  // 学号（序号）
            System.out.print(result_1.getString("name") + " ");  // 姓名
            System.out.println(result_1.getString("sex") + " ");  // 性别

        }
        System.out.println("==========================");
        manager_level.choose();

    }

    public static void function_two() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.println("请输入本人学号用于核实身份：");
        String one_id_2 = input.nextLine();
        ResultSet result_2 = statement.executeQuery("select * from students where id=\""+one_id_2+"\"");

        while (result_2.next()) {
            System.out.print(result_2.getInt("id") + " ");  // 学号（序号）
            System.out.print(result_2.getString("name") + " ");  // 姓名
            System.out.print(result_2.getString("building") + " ");  // 楼栋
            System.out.println(result_2.getString("room"));  // 房间号

        }
        System.out.println("==========================");
        manager_level.choose();

    }

    public static void function_three() throws SQLException, ClassNotFoundException {
        Statement statement = run_jdbc().createStatement();
        System.out.print("再次输入账号：");
        String one_uname_3 = input.nextLine();
        System.out.println("输入该账号的新密码：");
        String one_upass_3 = input.nextLine();
        statement.executeUpdate("UPDATE user SET upass=\""+one_upass_3+"\" WHERE uname=\""+one_uname_3+"\"");
        System.out.println("操作完成");

        System.out.println("==========================");
        manager_level.choose();
    }
}
