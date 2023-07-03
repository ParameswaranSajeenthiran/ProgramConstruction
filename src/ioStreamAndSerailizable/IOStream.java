package ioStreamAndSerailizable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOStream {
    public static void main(String[] args) {
        BufferedWriter fileWriter  =null;
        BufferedReader reader =null;
        try{
            fileWriter = new BufferedWriter( new FileWriter( "test.txt" ));

            fileWriter.write("testing file writing \n");
            fileWriter.write( " test \n");
            for ( int i =0 ;  i < 10 ; i++){
                fileWriter.write(" value of the string is "+String.valueOf(i) + "\n");
            }
            fileWriter.close();
            reader = new BufferedReader(new FileReader("test.txt"));
            String line =null;
            while ( (line = reader.readLine() )!=null){
                System.out.println( line);
            }
            reader.close();



        }catch (  IOException e ){
            e.printStackTrace();
        }finally {
            if( fileWriter !=null){

               try{
                   fileWriter.close();

               }catch ( IOException e){
                   e.printStackTrace();
               }
            }
        }

    }


    public List<String> loadFile (String filename){
        List<String > results= new ArrayList<>();
        BufferedReader bufferedReader=null;
        try{
            bufferedReader = new BufferedReader( new FileReader(filename));
            String line =null;
            while ( (line = bufferedReader.readLine()) !=null ){
                results.add(line);
            }

        }catch( IOException e ){
            e.printStackTrace();
        }
        return  results;
    }

    public void writeFile ( List<String> contents){

    }

    public void writeSerializableObject (){

    }
}
