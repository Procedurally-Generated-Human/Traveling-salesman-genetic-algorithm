public class Main {
    public static void main(String[] args){

        City c1 = new City(2,4);
        City c2 = new City(5,2);
        City c3 = new City(8,3);
        City c4 = new City(1,1);
        City c5 = new City(10,10);
        City[] cites = {c1,c2,c3,c4,c5};
        FitnessCalculator.setProblem(cites);

        int size = 300;
        Population pop = new Population(size, cites);

        for (int i = 0; i!=size ; i++) {
            pop.getIndividual(i).calculateFitness();
        }
        System.out.println(pop);
    }
}
