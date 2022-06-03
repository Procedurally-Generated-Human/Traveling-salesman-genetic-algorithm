public class Population {

    private final Individual[] individuals;
    private final int individualGeneSize;

    public Population(int size, int individualGeneSize){
        individuals = new Individual[size];
        this.individualGeneSize = individualGeneSize;
        for(int i=0; i!=individuals.length; i++){
            individuals[i] = new Individual(individualGeneSize);
        }
    }

    public void saveIndividual(Individual indiv, int index){
        individuals[index] = indiv;
    }

    public Individual getIndividual(int index){
        return individuals[index];
    }

    /*public Individual getFittest(){
        Individual fittest = individuals[0];
        for(int i=0; i!=individuals.length; i++){
            if(fittest.calculateFitness() < individuals[i].calculateFitness()){
                fittest = individuals[i];
            }
        }
        return fittest;
    }
     */

    public int size(){
        return individuals.length;
    }

    public String toString(){
        for(int i=0; i!=individuals.length; i++){
            System.out.print(individuals[i] + "\n");
        }
        return null;
    }


}
