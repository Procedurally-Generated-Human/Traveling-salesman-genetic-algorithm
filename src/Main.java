import java.util.Random;

public class Main {
    public static void main(String[] args){


        int noc = 50;
        City[] cites = new City[noc];
        Random r = new Random();
        for (int i = 0; i != noc ; i++) {
            int x = r.nextInt(100);
            int y = r.nextInt(100);
            City c = new City(x,y);
            cites[i] = c;
        }
        FitnessCalculator.setProblem(cites);

        int size = 100;
        Population pop = new Population(size, cites);

        for (int i = 0; i != 100000 ; i++) {
            System.out.println(pop.getFittest());
            pop = Algorithm.evolvePopulation(pop);
        }
    }
}
