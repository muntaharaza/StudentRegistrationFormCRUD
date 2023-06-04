package ManageBean;

import com.DbConnection;
import com.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "student")
public class StudentMB {
    Student stu;
    DbConnection conn;
    private Map<String,Object>sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }
    public StudentMB(){
        stu=new Student();
        conn=new DbConnection();
    }
    public StudentMB(Student stu){
        this.stu=stu;
    }
    public String register()
    {
        conn.insertRecord(stu.getFname(), stu.getLname(),stu.getEmail(),stu.getAge(), stu.getGender(),stu.getAddress());
        return "view.xhtml";
    }
    public List<Student>getAllRecords(){
        List<Student>allStudents=new ArrayList<Student>();
        ResultSet rs=conn.getRecords();
        try {
            while (rs.next())
            {
                Student user=new Student();
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getString("age"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                allStudents.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allStudents;
    }
    public void DeleteData(String email)
    {
        int rowsEffected=conn.deleteRecord(email);
        if (rowsEffected==1)
        {
            System.out.println("Record Deleted");
        }
        else {
            System.out.println("Record Not Deleted");
        }
    }
    public String getDataForEdit(Student stu)
    {
        System.out.println(stu.getEmail());
        sessionMap.put("editUser",stu);
        return "/editform.xhtml?faces-redirect=true";
    }
    public String updateRecord(Student stu) {

        try {
            conn.updateRecord(stu.getFname(), stu.getLname(), stu.getEmail(), stu.getAge(), stu.getGender(), stu.getAddress());
            System.out.println(stu.getGender());

        } catch (Exception e){

        }
        return "/view.xhtml?faces-redirect=true";
    }
}
