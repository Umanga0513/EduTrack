
package controller;

import java.util.Date;
import java.util.List;
import model.MStudent;

public class CStudent {
    public static MStudent model = null;
    
    public CStudent(){
        model = new MStudent();
    }
    
    public void addStudent(String id, String name, String email) throws Exception{
        model.addStudent(id, name, email);
    }
    
    public List<Object[]> getStudents() throws Exception {
        return model.getStudents();
    }
    
    public void updateStudent(String id, String name, String email) throws Exception{
        model.updateStudent(id, name, email);
    }
    
    public void deleteStudent(String id) throws Exception{
        model.deleteStudent(id);
    }
}
