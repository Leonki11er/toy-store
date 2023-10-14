import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {

   public void PrizesInfo(ArrayList<Toy> prizes){
       try(PrintWriter writer = new PrintWriter("raffle_result.txt", "UTF-8"))
       {
           for (int i = 0; i < prizes.size(); i++) {
               writer.println((i+1)+"й приз "+prizes.get(i).name);
           }
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
   }
}
