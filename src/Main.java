public class Main {
    public static void main(String[] args) {
        ToyStorage storage = new ToyStorage();
        storage.CreateToyStorage();
        GambleMachine machine = new GambleMachine();
        Integer[] weights = machine.DefineWeights(storage.toys);
        WriteToFile write = new WriteToFile();
        write.PrizesInfo(machine.RafflePrizes(storage.toys,10,weights));
    }
}