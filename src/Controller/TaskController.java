package Controller;

import Model.Task;
import Util.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class TaskController {
    public void save(Task task){
        String sql = "INSERT INTO task (name," +
                    "description, " +
                    "completed, " +
                    "notes, " +
                    "deadline, " +
                    "idProjects, " +
                    "cratedAt, " +
                    "updateAt) " +
                    "VALUES (?,?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionFactory.connectDB();
            statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isCompleted());
            statement.setString(4, task.getNotes());
            statement.setDate(5, new Date(task.getDeadLine().getTime()));
            statement.setInt(6, task.getIdProject());
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdateAt().getTime()));
            statement.execute();

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());

        }finally {
            ConnectionFactory.closeConnection(connection, statement);

        }
    }

    public void update(Task task) {
        String sql = "UPDATE task SET (name," +
                    "description," +
                    "completed, " +
                    "notes, " +
                    "deadline, " +
                    "idProjects, " +
                    "cratedAt, " +
                    "updateAt)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            statement.setString(1, task.getName());
            statement.setString(1, task.getDescription());
            statement.setBoolean(1, task.isCompleted());
            statement.setString(1, task.getNotes());
            statement.setDate(1, new Date(task.getDeadLine().getTime()));
            statement.setInt(1, task.getIdProject());
            statement.setDate(1, new Date(task.getCreatedAt().getTime()));
            statement.setDate(1, new Date(task.getUpdateAt().getTime()));
            statement.execute();

        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
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
            ConnectionFactory.closeConnection(connection, statement);
        }

    }
    public List<Task> getAll(int idProject){
        return null;
    }
}
