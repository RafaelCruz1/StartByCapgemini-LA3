package Controller;

import Model.Task;
import Util.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class TaskController {
    public void save(Task task){

    }
    public void update(Task task) {

    }
    public void removeById(int taskId){
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement =null;

        try {
            connection = ConnectionFactory.connectDB();
            statement =connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        }catch (Exception e ){
            JOptionPane.showMessageDialog(null, "Erro ao deletar o id " + e.getMessage());
        }
        finally {
            ConnectionFactory.closeConnection(connection);
        }

    }
    public List<Task> getAll(int idProject){
        return null;
    }
}
