package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MCourse {
    
    public MCourse(){
    }

    public void addCourse(String name, String fee, String detail, Date date) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO course (name, fee, details, startDate) VALUES (?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, fee);
        pst.setString(3, detail);
        pst.setDate(4, new java.sql.Date(date.getTime()));

        pst.executeUpdate();
    }
    
    public void updateCourse(int id, String name, String fee, String detail, Date date) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE course SET name = ?, fee = ?, details = ?, startDate = ? WHERE id = ?";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, fee);
        pst.setString(3, detail);
        pst.setDate(4, new java.sql.Date(date.getTime()));
        pst.setInt(5, id);

        pst.executeUpdate();
    }
    
    public void deleteCourse(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "DELETE from course WHERE id = ?";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);

        pst.executeUpdate();
    }

    public List<Object[]> getCourses() throws Exception {
        List<Object[]> courseList = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            String query = "SELECT * FROM course";
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
            throw new Exception("Error retrieving courses", e);
        }

        return courseList;
    }

}
