package Controller;

import Model.Project;
import Util.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ProjectController {

    public void save(Project project){
        String sql = "INSERT INTO projects (name," +
                "description, " +
                "cratedAt, " +
                "updateAt) " +
                "VALUES (?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionFactory.connectDB();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdateAt().getTime()));
            statement.execute();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar o projeto " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update (Project project) {
        String sql= "UPDATE projects SET (name = ?," +
                "description = ?," +
                "cratedAt = ?, " +
                "updateAt = ?)" +
                " WHERE id = ? ";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.connectDB();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdateAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o id " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
