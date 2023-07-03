import java.io.*;


class WriteFile{
        public static void main(String[] args) {

            try{
                FileWriter writer =new FileWriter("TestWrite.txt");
                BufferedWriter writer1=new BufferedWriter(writer);
                writer.write("hello foo!\n hello how are you \n are you studying program construction");
                writer.close();

                FileReader fileReader=new FileReader("TestWrite.txt");
                BufferedReader reader =new BufferedReader(fileReader);
                String line =null;
                while ((line =reader.readLine())!=null){
                    System.out.println(line);
                }

                reader.close();

            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
}


class SerializingObjects{






    public static void main(String[] args) {
        try{
            TestObject testObject=new TestObject("tes object ");


            FileOutputStream fileOutputStream = new FileOutputStream("SerializedFile.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(testObject);
            os.close();


            FileInputStream fileInputStream=new FileInputStream("SerializedFile.ser");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

            TestObject testObject1=(TestObject) objectInputStream.readObject();
            System.out.println(testObject1.data);
            objectInputStream.close();



        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
class TestObject implements  Serializable{
    String data;

    TestObject(String data){
        this.data=data;
    }

}