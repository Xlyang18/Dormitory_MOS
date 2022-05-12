package LOG_IN;
/*
*登录实现
* 功能实现：确定登录用户是否存在以及，区分用户等级
* */

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;
import MANAGER.manager;
import MANAGER.command_UI_manager;
import STUDENTS.students;
import STUDENTS.command_UI_student;

public class log_in {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL连接驱动加载成功");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","123456");
            System.out.println("MySQL连接成功");

            command_UI.one();


            System.out.print("输入登录账号");
            String uname =  input.nextLine();
            System.out.print("输入登录密码");
            String upass =  input.nextLine();


            // 创建SQL语句的执行环境
            Statement statement = connect.createStatement();
            // 执行语句获得结果
            ResultSet result = statement.executeQuery("SELECT * FROM "+"user");       //SQL语句可以字符串拼接
            while (result.next()){
                String one_uname = result.getString("uname");
                String one_upass = result.getString("upass");
                String one_type = result.getString("type");

                if(Objects.equals(uname, one_uname)){
                    if (Objects.equals(upass, one_upass)){
                        System.out.println("已在数据库中查询到该账号信息");
//                        System.out.println("type："+one_type);
                        switch (one_type){
                            case "1":
                                command_UI.end();
                                System.out.println("账号类型：管理员账号");
                                new command_UI_manager().start();
                                new manager().main(null);
                                break;
                            case "2":
                                command_UI.end();
                                System.out.println("账号类型：学生账号");
                                new command_UI_student().start();
                                new students().main(null);
                                break;
                            case "9":
                                main(null);
                            default:
                                System.out.println(" ");
                        }
                    }
                }
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println(">MySQL连接驱动加载失败<");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(">数据库连接失败<");
        }

    }
}
