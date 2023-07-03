package designPatterns.momento.uni;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DataCommonModule {
    public static void main(String[] args) {
        List<IOManager.InputBlock> journal=new ArrayList<IOManager.InputBlock>();
        IOManager iomgr=new IOManager();
        int [] d= new  int [8];
        d[0]=0; d[1]=1; d[2]=2; d[3]=3; d[4]=4; d[5]=5; d[6]=6; d[7]=7;
        iomgr.set(d,0x0033);
        iomgr.print();
        d[0]=1; d[1]=2; d[2]=3; d[3]=4;
        iomgr.set(d,0x0031);
        iomgr.print();
        journal.add(iomgr.save());
        d[0]=2; d[1]=3; d[2]=4; d[3]=5;
        iomgr.set(d,0x0011);
        iomgr.print();
        d[0]=3; d[1]=4; d[2]=5; d[3]=6;
        iomgr.set(d,0x0013);
        iomgr.print();
        System.out.println("restoring ");
        iomgr.restore(journal.get(0));
        iomgr.print();
    }



}

class IOManager{

    private int [] data;
    private int code ;

    public IOManager(){
        data=new int[8];

    }

    public void set(int [] data,int code ){

        for (int i=0;i<8;i++){
            this.data[i]=data[i];
        }

        this.code =code ;
    }

    public InputBlock save(){
        return new InputBlock(this.data,this.code);
    }

    public void restore(InputBlock inputBlock){
        this.data=inputBlock.getData();
        this.code=inputBlock.getCode();

    }

    public void print() {System.out.print(code+": ");for(int i=0; i<8; i++)System.out.print(data[i]);System.out.println();}


     static class  InputBlock{
        private final int [] data;
        private final int code ;

        public InputBlock(int[] data,int code ){
            this.data=new int[8];
            for (int i=0;i<8;i++){
               this.data[i]= data[i];
            }

            this.code =code ;

        }
        public int [] getData(){
            return data;
        }

        public int getCode(){
            return code;

         }

    }






}






