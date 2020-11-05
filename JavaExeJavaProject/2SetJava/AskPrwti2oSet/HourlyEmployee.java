public class HourlyEmployee extends Employee{
    private int hoursWorked;
    private int hourlyPayment;
    
    public void setHoursWorked(int newhoursworked){this.hoursWorked=newhoursworked;}
    public int getHoursWorked(){return this.hoursWorked;}
    
    public void setHourlyPayment(int newhourlypayment){this.hourlyPayment=newhourlypayment;}
    public int getHourlyPayment(){return this.hourlyPayment;}
    
    public int payment(){
        return this.hoursWorked*this.hourlyPayment;
    }
}
