import java.io.*;
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.FileWriter;
import java.io.BufferedReader;

public class FileHandlerrr
{   
    FileReader fr;
    long f1Megethos;
    long f2Megethos;
    long f3Megethos;
    long f4Megethos;
    int newlinecounter;
    int whitespacecounter;
    
    public static void main(String args[])throws IOException{
        
       FileHandlerrr c=new FileHandlerrr();
       c.Checker();
       
       FileHandlerrr car=new FileHandlerrr();
       car.dyotria();
      
    }
    
    //chekarei an yparxei to src
    public void Checker()throws IOException{
        
        fr=null; 
        try
        { 
            fr = new FileReader("src.txt"); 
        } 
        catch (FileNotFoundException fe) 
        { 
            System.out.println("File not found"); 
        }
        
        fr.close();
    }
    
    
    public void dyotria()throws IOException{
        try {
            
            File f1=new File("src.txt");
            File f2=new File("newfile.txt");
            
            f1Megethos=f1.length();
            f2Megethos=f2.length();
            
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(f2, true);
            
            String str;
            String oldContent = "";
            //String newline=System.getProperty("line.separator");
            
            while ((str = br.readLine()) != null) {
                
                oldContent = oldContent + str + System.lineSeparator();
               // str = br.readLine();
                
               // fw.write(str); // write to output file
               // fw.flush();
               
                //if(str==newline){newlinecounter++;}
                if(str==" "){
                   whitespacecounter++;
                }
                
            }
              
            String newContent = oldContent.replaceAll("\\s+", "\\$");
            newContent = newContent.replaceAll("\n","\n\n");
            fw.write(newContent);
            
            br.close();
            fw.close();
            
            System.out.println("file copied and changed");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
         
         File f3=new File("src.txt");
         File f4=new File("newfile.txt");
         
         f3Megethos=f3.length();
         f4Megethos=f4.length();
        
         System.out.println("Megethos prin tou src :" + f1Megethos + ",megethos tou newfile " + f2Megethos);
         System.out.println("Megethos meta tou src :" + f3Megethos + ",megethos meta tou newfile "+ f4Megethos);
         System.out.println("Ta kena itan:" + whitespacecounter);
        


    }
}
