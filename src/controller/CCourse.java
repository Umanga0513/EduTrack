
package controller;

import java.util.Date;
import java.util.List;
import model.MCourse;

public class CCourse {
    public static MCourse model = null;
    
    public CCourse(){
        model = new MCourse();
    }
    
    public void addCourse(String name, String fee, String detail, Date date) throws Exception{
        model.addCourse(name, fee, detail, date);
    }
    
    public List<Object[]> getCourses() throws Exception {
        return model.getCourses();
    }
    
    public void updateCourse(int id, String name, String fee, String detail, Date date) throws Exception{
        model.updateCourse(id, name, fee, detail, date);
    }
    
    public void deleteCourse(int id) throws Exception{
        model.deleteCourse(id);
    }
}
