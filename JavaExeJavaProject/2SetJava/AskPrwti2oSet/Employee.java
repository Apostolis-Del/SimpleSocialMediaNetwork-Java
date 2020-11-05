public abstract class Employee
{
    private String name;
    private String afm;
    private int EmpID=1;
    
    
    public void setName(String newname){this.name=newname;}
    public String getName(){return this.name;}
    
    public void setAfm(String newafm){this.afm=newafm;}
    public String getAfm(){return this.afm;}
    
    public void setEmpID(int newempid){this.EmpID=newempid;}
    public int getEmpID(){return this.EmpID;}
    
    public Employee(){
        this.EmpID=EmpID;
        EmpID=EmpID+1;
        
        
    }
    
    
    abstract int payment();
   
    
    
    
    
}

