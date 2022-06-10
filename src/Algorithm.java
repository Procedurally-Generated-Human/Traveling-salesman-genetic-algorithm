import java.util.*;

public class Algorithm {

    private static final int numberOfMutations = 1;
    private static final int tournamentSize = 10;
    private static final boolean elitism = true;
    private static java.util.Arrays Arrays;

    public static Population evolvePopulation(Population pop, City[] cities){
        Population newPop = new Population(pop.size);
        Individual fittest = pop.getFittest();
        for(int i=0; i!=pop.size; i++){
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            Individual newIndiv = crossover(indiv1, indiv2);
            newPop.saveIndividual(newIndiv, i);
        }
        if (elitism){
            newPop.saveIndividual(fittest, 0);
        }
        return newPop;
    }

     public static Individual crossover(Individual ind1, Individual ind2) {
        Random random = new Random();
        int size = ind1.getGeneLength();

        ArrayList<City> parent1Genes = new ArrayList<>(java.util.Arrays.asList(ind1.getGenes()));
        ArrayList<City> parent2Genes = new ArrayList<>(java.util.Arrays.asList(ind2.getGenes()));

        int geneA = random.nextInt(0,size-1);
        int geneB = random.nextInt(0,size);

        int startGene = Math.min(geneA, geneB);
        int endGene = Math.max(geneA, geneB);

        Individual child = new Individual(ind1.getGenepool());
        ArrayList<City> childGenes = new ArrayList<>(java.util.Arrays.asList(child.getGenes()));
        childGenes.clear();
        childGenes.addAll(parent1Genes.subList(startGene, endGene));

         int currentCityIndex = 0;
         int currentCityInTour1 = 0;
         int currentCityInTour2 = 0;
         for (int i = 0; i < size; i++) {
             currentCityIndex = (endGene + i) % size;

             currentCityInTour1 = parent1Genes.indexOf(parent1Genes.get(currentCityIndex));
             currentCityInTour2 = parent2Genes.indexOf(parent2Genes.get(currentCityIndex));

             if (!childGenes.contains(parent2Genes.get(currentCityInTour2))) {
                 childGenes.add(parent2Genes.get(currentCityInTour2));
             }
         }
         Collections.rotate(childGenes, startGene);
         for (int i = 0; i != size ; i++) {
             child.setGene(childGenes.get(i) ,i);
         }
         mutate(child);
         return child;

     }

    public static void mutate(Individual indiv){
        Random random = new Random();
        for(int n=0; n!=numberOfMutations; n++){
            int r1 = random.nextInt(indiv.getGeneLength());
            int r2 = random.nextInt(indiv.getGeneLength());
            City temp = indiv.getGene(r1);
            indiv.setGene(indiv.getGene(r2),r1);
            indiv.setGene(temp,r2);
        }
    }

    private static Individual tournamentSelection(Population pop){
        Population tournament = new Population(tournamentSize);
        for(int i=0; i!=tournamentSize; i++){
            int randomId = (int) (Math.random() * pop.size);
            tournament.saveIndividual(pop.getIndividual(randomId), i);
        }
        return tournament.getFittest();
    }
}
