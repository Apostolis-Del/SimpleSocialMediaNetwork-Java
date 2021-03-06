public class Person {
    
private String lastname;
private String firstname;
private int age;
private boolean married;
private float salary;
public static final int MALE = 0;
public static final int FEMALE = 1;
private int sex; 

public Person (String lastname, String firstname, int age, boolean married,
float salary, int sex) {
 this.lastname = new String(lastname);
 this.firstname = new String(firstname); 
 this.age = age;
 this.married = married;
 this.salary = salary;
 this.sex = sex;
} 

public void printInfo(){
    System.out.println(this.getFirstName()+" "+this.getLastName()+" is "
     +this.getAge() +" years old, gets a "+this.getSalary() 
     +" Euros salary and is");
    if (this.isMarried() == false){
     System.out.print(" not");
     System.out.println(" married. \n");}
    }
    
public String getLastName() { return lastname; }
public void setLastName(String last){
    this.lastname=last;}
    
public String getFirstName() { return firstname; }
public void setFirstName(String first){
    this.firstname=first;}
    
public int getAge() { return age; }
public void setAge(int a){
    this.age=a;}
    
public boolean isMarried() { return married; }
public void setMarried(boolean mar){
    this.married=mar;}
    
public float getSalary() { return salary; }
public void setSalary(float sal){
    this.salary=sal;}
    
public int getSex() { return sex; }    
public void setSex(int s) { this.sex=s; }   
} 
