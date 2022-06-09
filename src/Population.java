public class Population {

    private final Individual[] individuals;
    public final int size;


    public Population(int size, City[] cities){
        this.size = size;
        individuals = new Individual[size];
        for(int i=0; i!=individuals.length; i++){
            individuals[i] = new Individual(cities);
        }
    }

    public Population(int size){
        this.size = size;
        individuals = new Individual[size];
    }

    public void saveIndividual(Individual indiv, int index){
        individuals[index] = indiv;
    }

    public Individual getIndividual(int index){
        return individuals[index];
    }

    public Individual getFittest(){
        Individual fittest = individuals[0];
        for(int i=0; i!=individuals.length; i++){
            if(fittest.calculateFitness() < individuals[i].calculateFitness()){
                fittest = individuals[i];
            }
        }
        return fittest;
    }



    public String toString(){
        for(int i=0; i!=individuals.length; i++){
            System.out.print(individuals[i] + "\n");
        }
        return null;
    }


}
