import java.util.ArrayList;
import java.util.Random;

public class GambleMachine {
    Random random = new Random();
    public  Integer[] DefineWeights(ArrayList<Toy> toys){
        Integer[] weights = new Integer[toys.size()*2];
        for (int i = 0; i < toys.size(); i++) {
            if(i==0)weights[0]=1;
            else weights[i*2]=weights[i*2-1]+1;
            weights[i*2+1]=weights[i*2]+toys.get(i).wheight-1;
        }
        return weights;
    }

    public Integer Gamble(Integer[] weights){
        int r = random.nextInt(100+1);
        Integer result = 0;
        for (int i = 0; i < weights.length/2; i++)
        {
            if(r<=weights[i*2+1]&&r>=weights[i*2]){
                result=i;
            }
        }
        return result;
    }

    public ArrayList<Toy> RafflePrizes(ArrayList<Toy> toys, Integer rollsAmount,Integer[] weights){
        ArrayList<Toy> prizes = new ArrayList<Toy>();
        for (int i = 0; i < rollsAmount; i++)
        {
            Integer j=0;
            boolean outOfStock = true;
            while (outOfStock){
                j = Gamble(weights);
                if(toys.get(j).stock>0)outOfStock=false;
            }
            toys.get(j).stock -=1;
            prizes.add(toys.get(j));
        }
        return prizes;
    }

}
