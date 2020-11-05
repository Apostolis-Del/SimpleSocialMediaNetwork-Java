import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.io.FileWriter;
import java.util.ArrayList;


public class Wall extends User
{
  
    public  Wall()
    {
        
    }
    
    //constructor gia ektipwsi tou wall 
    
    public  Wall(String name)
    {
        //dimiourgia i anoigma tou userposts.txt to opoio tha einai to database pou tha periexei
        //ta posts tou ekastote user
        
         File temp_file_1=new File("usersposts.txt");
       try{
           
           // File temp_file_1=new File("usersposts.txt");
            boolean file_exists=temp_file_1.exists();
            FileInputStream file_input=new FileInputStream("usersposts.txt");
            
        }catch(FileNotFoundException fnfe){
            
            System.out.println("The file \"usersposts.txt\" wasn't found in this directory.");
            System.exit(0);
            
        }
        
        
        try{
            
            BufferedWriter writer = null;

            BufferedReader buf = new BufferedReader(new FileReader("usersposts.txt"));
            ArrayList<String> posts = new ArrayList<>();
            ArrayList<String> words = new ArrayList<>();
            
            String line = null;
            String[] wordsArray;
            
            int giatalikes=0;
            int i=1;
            int giatoprwto=0;
            
            while(true){
                
                line = buf.readLine();
                
                if(line == null){  
                    
                    break; 
                    
                }else{
                    
                    wordsArray = line.split(",");
                    
                    for(String helper : wordsArray){
                    
                        if(!"".equals(helper)){
                            
                            words.add(helper);
                                      
                        }
                        
                        if(wordsArray[0].contains(name)){
                            
                            //giatoprwto einai epeidi emfanizotan kai to name tou xristi
                            //gia ta likes einai gia na mpainoun ta likes ena tab pio mesa
                            
                            giatalikes++;
                            giatoprwto++;
                            
                            if(giatoprwto>1){
                                
                                    if((giatalikes%2==1)&&(giatalikes>1)){
                                        
                                    System.out.println(" "+ "\t" + helper);
                                
                                   }    
                                   else{  
        
                                        System.out.println(i +" "+ helper);
                                        i++;
                                    }
        
                                    posts.add(helper);
                            

                          }
                        }
                        
                    }
                }
            }

            buf.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //methodos gia writing ston toixo tou user
    
    public void WriteToWall(String user1,String context){
        
        File temp_file_1=new File("usersposts.txt");

        List<String> friendreq = new ArrayList<String>();
        
         try{
             
            String newLineChar = System.getProperty("line.separator");

            BufferedReader buf = new BufferedReader(new FileReader("usersposts.txt"));
            ArrayList<String> words = new ArrayList<>();  
            
            String line = null;
            String[] wordsArray;

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("usersposts.txt", true)));
            
            StringBuffer inputBuffer = new StringBuffer();

            String inputStr="";
            while(true){
                
                int k=0;
                line = buf.readLine();
                
                if(line == null){  
                    
                    break; 
                    
                }else{
                    
                    inputBuffer.append(line);
                    wordsArray = line.split(",");
    
                        if( wordsArray[0].contains(user1)){

                                                inputBuffer.append("," + context + "," + "0 Likes");
                           
                        }
                    
                    inputBuffer.append(newLineChar);
                    
                }             
            }
                        
                buf.close();
                inputStr = inputBuffer.toString();
                //System.out.println("----------------------------------\n" + inputStr);
               
        
                File file = new File("usersposts.txt");
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(inputStr);
                bufferedWriter.close();
                inputBuffer.setLength(0);
                
        }catch(Exception e){} 

        
        
        
    }
    
    //edw thelame na kanoume kati gia tin prosthiki twn likes alla den mas bgike
    
    public void Addlikes(String user1,String context){
          File temp_file_1=new File("usersposts.txt");


        List<String> friendreq = new ArrayList<String>();
         try{
             String newLineChar = System.getProperty("line.separator");

            BufferedReader buf = new BufferedReader(new FileReader("usersposts.txt"));
            ArrayList<String> words = new ArrayList<>();           
            String lineJustFetched = null;
            String[] wordsArray;
            int i =0;

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("usersposts.txt", true)));
            
            StringBuffer inputBuffer = new StringBuffer();

         



            String inputStr="";
            while(true){
                int k=0;
                lineJustFetched = buf.readLine();
                if(lineJustFetched == null){  
                    break; 
                }else{
                    
                    inputBuffer.append(lineJustFetched);
                    

                    wordsArray = lineJustFetched.split(",");

                    //for(String each : wordsArray){
                        
                        if( wordsArray[0].contains(user1)){

                                                inputBuffer.append("," + context + "," + "0 Likes");
                           
                        }
                    //}
                    inputBuffer.append(newLineChar);
                }             
            }
            buf.close();
             inputStr = inputBuffer.toString();
            System.out.println("----------------------------------\n" + inputStr);
           
        
        File file = new File("usersposts.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(inputStr);
        bufferedWriter.close();
        inputBuffer.setLength(0);
        
        }catch(Exception e){} 

        
        
        
    }
    
    //methodos gia grapsimo ston toixo enos filou tou user
    
    public void WriteToFriendsWall(String user1,String context){
        
        File temp_file_1=new File("usersposts.txt");
        List<String> friendreq = new ArrayList<String>();
        
         try{
             
            String newLineChar = System.getProperty("line.separator");

            BufferedReader buf = new BufferedReader(new FileReader("usersposts.txt"));
            ArrayList<String> words = new ArrayList<>();  
            
            String line = null;
            String[] wordsArray;

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("usersposts.txt", true)));
            
            StringBuffer inputBuffer = new StringBuffer();

            String inputStr="";
            
            while(true){
                
                int k=0;
                line = buf.readLine();
                
                if(line == null){  
                    
                    break; 
                    
                }else{
                    
                    inputBuffer.append(line);
                    wordsArray = line.split(",");
                    
                        if( wordsArray[0].contains(user1)){

                                                inputBuffer.append("," + context + "," + "0 Likes");
                           
                        }

                    inputBuffer.append(newLineChar);
                }             
            }
            
            buf.close();
            inputStr = inputBuffer.toString();
            //System.out.println("----------------------------------\n" + inputStr);
          
            
            File file = new File("usersposts.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(inputStr);
            bufferedWriter.close();
            inputBuffer.setLength(0);
          
        }catch(Exception e){}   
        
    }
    }    



