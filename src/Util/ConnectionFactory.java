package Util;

import javax.swing.*;
import java.sql.*;

public class ConnectionFactory {

    public static Connection connectDB() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/todoapp";
            conn = DriverManager.getConnection(url);

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null,"ConnectDB" + error.getMessage());
        }
        return conn;
    }

    public static void closeConnection(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao" + error.getMessage());
        }
    }
    public static void closeConnection(Connection connection, PreparedStatement statement){
        try {
            if (connection != null){
                connection.close();
            }

            if (statement != null){
                statement.close();
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao" + error.getMessage());
        }
    }
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao" + error.getMessage());
        }
    }
}
