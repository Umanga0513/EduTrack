package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MStudent {
    
    public MStudent(){
    }

    public void addStudent(String id, String name, String email) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO student  VALUES (?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, id);
        pst.setString(2, name);
        pst.setString(3, email);

        pst.executeUpdate();
    }
    
    public void updateStudent(String id, String name, String email) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE student SET name = ?, email = ? WHERE id = ?";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, id);

        pst.executeUpdate();
    }
    
    public void deleteStudent(String id) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "DELETE from student WHERE id = ?";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, id);

        pst.executeUpdate();
    }

    public List<Object[]> getStudents() throws Exception {
        List<Object[]> courseList = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            String query = "SELECT * FROM student";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                courseList.add(row);
            }
        } catch (Exception e) {
            throw new Exception("Error retrieving students", e);
        }

        return courseList;
    }

}
