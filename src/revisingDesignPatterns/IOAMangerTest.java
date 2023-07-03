package revisingDesignPatterns;

import java.util.Arrays;

public class IOAMangerTest {


}

class IOManager{
    private int[] data ;
    private double code ;

    public void  set( int code , int [] data){
        this.code =code ;
        for (int i=0; i< data.length;i++) this.data[i]=data[i];

    }

    public InputBlock save ( int[] data, int code  ){
        return new InputBlock(data,code) ;
    }

    public void restore (InputBlock inputBlock ){
        this.data=inputBlock.data;
        this.code =code ;
    }

    static class InputBlock {
        private int[] data;
        private int code ;
        public InputBlock( int[] data , int code ){
            this.data=data;
            this.code =code;

        }

    }
}