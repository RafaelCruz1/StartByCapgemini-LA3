package Controller;

import Model.Project;
import Model.Task;
import Util.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<Project> getAll() {
        String sql = "SELECT * FROM projects ";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<>();

       try{
           connection = ConnectionFactory.connectDB();
           statement = connection.prepareStatement(sql);
           resultSet = statement.executeQuery();

           while (resultSet.next()){
               Project project =new Project();

               project.setId(resultSet.getInt("id"));
               project.setName(resultSet.getString("name"));
               project.setDescription(resultSet.getString("description"));
               project.setCreatedAt(resultSet.getDate("createdAt"));
               project.setUpdateAt(resultSet.getDate("updateAt"));

               projects.add(project);
           }

       }catch (Exception e ){

       }finally {
           ConnectionFactory.closeConnection(connection, statement, resultSet);
       }
       return projects;
    }
}
