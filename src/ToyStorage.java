import java.util.ArrayList;
import java.util.Scanner;

public class ToyStorage {
    public ArrayList<Toy> toys = new ArrayList<Toy>();

    public void AddToy(Integer id, String name, Integer stock, Integer wheight){
        Toy toy = new Toy();
        toy.CreateToy(id, name, stock, wheight);
        toys.add(toy);
    }

    public void ClearStorage(){
        toys.clear();
        System.out.println("Превышена суммарная вероятность выпадения(>100), введите значения заново");
        CreateToyStorage();
    }

    public void CreateToyStorage(){
        Integer totalweight = 100;
        Integer weight;
        System.out.println("Введите количество наименований игрушек(целое число)");
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        for (int i = 1; i <= quantity; i++) {
            System.out.println("Введите название "+i+"й игрушки");
            String title = scanner.next();
            if(i<quantity){
                System.out.println("Введите вероятность выпадения "+i+"й игрушки(суммарно вероятность выпадения всех игрушек не должна превышать 100)");
                weight = scanner.nextInt();
                totalweight -= weight;
                if(totalweight<=0)ClearStorage();
                System.out.println("Остаток 'веса'= "+totalweight);
            }
            else{
                System.out.println("Для последней ("+i+"й) игрушки вероятность будет определятся остатком 'веса'("+totalweight+")");
                weight = totalweight;
            }
            System.out.println("Введите количество "+i+"й игрушки(суммарно количество игрушек должно быть >10)");
            Integer stock = scanner.nextInt();
            AddToy(i,title,stock,weight);
        }
    }
}
