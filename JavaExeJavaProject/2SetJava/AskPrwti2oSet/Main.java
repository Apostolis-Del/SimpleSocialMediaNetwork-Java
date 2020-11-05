public class Main{
    public static void main(String args[]){
        Employee ListaHaS[]=new Employee[2];
        ListaHaS[0]= new SalariedEmployee();
        ListaHaS[1]= new HourlyEmployee();
        
        //ListaHaS[0].setEmpID(1);
        ListaHaS[0].setName("Nikos Patzios");
        ListaHaS[0].setAfm("72340002");
        ((SalariedEmployee)ListaHaS[0]).setSalary(3000);
        
         ListaHaS[1].setName("Sofia Christou");
        ListaHaS[1].setAfm("98145000");
        ((HourlyEmployee)ListaHaS[1]).setHoursWorked(210);
        ((HourlyEmployee)ListaHaS[1]).setHourlyPayment(20);
        
        
        for(int i=0; i<2;i++){
            System.out.println("Employee ID: "+ ListaHaS[i].getEmpID()+ "\n" +
            "Employee Name:" + ListaHaS[i].getName()+ "\n" +
            "Employee AFM: "+ ListaHaS[i].getAfm()+ "\n" +
            "Employee Payment: " + ListaHaS[i].payment()+"\n");  
        }
        
        Company cmp1=new Company("TalentSA");
        cmp1.addEmployee(ListaHaS[0]);
        cmp1.addEmployee(ListaHaS[1]);
        
        System.out.println("Employees working for " + cmp1 + ":\n" +
            cmp1.myEmployees
            );
    }
    
    
    
    
    
}
