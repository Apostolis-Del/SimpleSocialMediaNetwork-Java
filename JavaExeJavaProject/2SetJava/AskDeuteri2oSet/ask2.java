import java.io.*; 
import java.io.IOException;

public class ask2
{    
        public static void main(String[] args){
            System.out.print("Grapste ton prwto arithmo(x): ");
            int x=readInt();
            System.out.print("Grapste ton deutero arithmo(y): ");
            int y=readInt();
            
            try{
                if((x==2)){
                    System.out.println("Den mporei na ginei diairesi, paronomastis isos me 0");
                }else{
                    System.out.println("To apotelesma einai "+ praksi(x,y) + ".");
                }
            }catch(ArithmeticException ae){
                System.out.println("O paronomastis bgainei 0");
            }
        }
        public static double praksi(int x,int y)throws ArithmeticException{
            double k = (x-7)*y;
            double t = k/(x-2);
            
            if(t==Double.POSITIVE_INFINITY  || t==Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("ArithmetiExpression: O paronomastis bgainei 0");
        }
            
            return t;
            
            
            
        }
  
       public static int readInt(){
            byte b[]=new byte[16];
            String str;
            
            try{
                System.in.read(b);
                str=(new String(b)).trim();
                return Integer.parseInt(str);
            }catch(IOException ioe){
                System.out.println("IOException: "+ioe.toString()+".");
                return 0;
            }catch(NumberFormatException nfe){
                System.out.println("NumberFormatException: "+nfe.toString()+".");
                return -1;
            }
        }
} 