import java.util.ArrayList;

public class Main {

    /**
     * Unit tests the {@code BTree} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)
    {

        BTree<String, String> st = new BTree<String, String>();
        ArrayList<String[]> csvFileList=ReadCSV.read();

        ArrayList<String> elementList=new ArrayList<String>();

        for(String[] a: csvFileList)
        {
            st.put(a[0],a[1]);
            int address=System.identityHashCode(a[0]);  //根据对象物理内存地址返回哈希值

            elementList.add(String.valueOf(a[0]));

        }

        WriteExcel.write(elementList);

        long startTime=System.nanoTime();
        String result=st.get("2018/5/8 13:52:17");
        long endTime=System.nanoTime();
        System.out.println(result);
        System.out.println("时间"+(endTime-startTime)+"ns");



    }
}
