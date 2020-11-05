public class SalariedEmployee extends Employee{
    private int salary;
    
    public void setSalary(int newsalary){
        this.salary=newsalary;  
    }
    public int payment(){
        return this.salary;    
    }
    
}
