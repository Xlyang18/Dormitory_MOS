package NEW_Run;

/*
*
* */
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;
import ALL_UI.run_ui;


public class run {

    // 获取输入的静态方法
    private static Scanner input = new Scanner(System.in);


    // 创建jdbc连接的方法
    public static Connection run_jdbc(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQl连接驱动加载成功");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","MySql.13593977512L");
            System.out.println("MySQL连接成功");
            return connect;

        }catch (ClassNotFoundException e) {
            // 处理 forName异常-->16
            e.printStackTrace();
        } catch (SQLException e) {
            // 处理 getConnection异常-->18
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        run_ui.start();
        System.out.print("输入登录账号");
        String uname =  input.nextLine();
        System.out.print("输入登录密码");
        String upass =  input.nextLine();


        // 创建SQL语句的执行环境
        Statement statement = run_jdbc().createStatement();
        // 执行语句获得结果
        ResultSet result = statement.executeQuery("SELECT * FROM "+"user");       //SQL语句可以字符串拼接
        while (result.next()){
            String one_uname = result.getString("uname");
            String one_upass = result.getString("upass");
            String one_type = result.getString("type");

            if(Objects.equals(uname, one_uname)){
                if (Objects.equals(upass, one_upass)){
                    System.out.println("已在数据库中查询到该账号信息");
                    run_ui.end();
                    switch (one_type) {
                        case "1":
                            run_ui.start();
                            System.out.println("账号类型：管理员账号");
                            ALL_UI.manager_ui.start();
                            break;
                        case "2":
                            run_ui.start();
                            System.out.println("账号类型：学生账号");
                            ALL_UI.students_ui.start();
                            break;
                        default:
                            System.out.println("");
                    }
                    }
                }
        }
    }
}




