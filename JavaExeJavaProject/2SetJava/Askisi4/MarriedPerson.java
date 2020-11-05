public class MarriedPerson extends Person {
    private int children;
    
    public MarriedPerson(String lastname, String firstname, int age, float salary,
    int sex, int children) {
     super(lastname, firstname, age, true, salary, sex);
     this.children = children;
    } 
    public void setMarried(boolean mar){}
    
    public void setSalary(MarriedPerson spouse) {
            float temporary;
            if (spouse.getSex()!=this.getSex()){
                temporary=this.getSalary()+spouse.getSalary();
                this.setSalary(temporary);
            }
        }
        
    public void printInfo(){
     super.printInfo();
     System.out.print("married with ");
     if (this.getNoOfChildren() > 0)
     System.out.print(this.getNoOfChildren()+ " children\n");
     else {
        System.out.print("no");
     System.out.println(" children.\n");} 
    }
    
    public int getNoOfChildren() { return children; }
    public void setNoOfChildren(int child) { this.children=child; }
} 
