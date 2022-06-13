public class Population {

    private final Individual[] individuals;
    private final int size;


    public Population(int size, City[] cities){
        this.size = size;
        individuals = new Individual[size];
        for(int i=0; i!=individuals.length; i++){
            individuals[i] = new Individual(cities, true);
        }
    }

    public Population(int size){
        this.size = size;
        individuals = new Individual[size];
    }

    public void setIndividual(Individual indiv, int index){
        individuals[index] = indiv;
    }

    public Individual getIndividual(int index){
        return individuals[index];
    }
    public Individual getFittest(){
        Individual fittest = individuals[0];
        for(int i=0; i!=individuals.length; i++){
            if(fittest.calculateFitness() > individuals[i].calculateFitness()){
                fittest = individuals[i];
            }
        }
        return fittest;
    }
    public int getSize() {
        return size;
    }

    public String toString(){
        StringBuilder data = new StringBuilder();
        for(int i=0; i!=individuals.length; i++){
            data.append(individuals[i]);
            data.append("\n");
        }
        return data.toString();
    }


}
