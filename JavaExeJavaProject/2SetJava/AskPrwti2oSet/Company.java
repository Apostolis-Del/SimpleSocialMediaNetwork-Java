import java.util.*;
public class Company {
    private String name;
    private String afm;
    private String compname;
    
    public Company(String compname){
        this.compname=compname;
        
    }
  
    List<Employee> myEmployees=new ArrayList<Employee>();
    
    public void addEmployee(Employee kappa){
            myEmployees.add(kappa);
        }

    public int payment(){return 0;}
}
