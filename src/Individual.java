import java.util.*;

public class Individual {

    private final int geneLength;
    private City[] genes;
    private double fitness = 0;
    private City[] genepool;

    public Individual(City[] genePool){
        setGenepool(genePool);
        this.geneLength = genePool.length;
        genes = new City[geneLength];
        generateGenes(genePool);
    }

    private void generateGenes(City[] genePool){
        Random r = new Random();
        List<City> geneList = new ArrayList<City>(Arrays.asList(genePool));
        for(int i=0; i!=geneLength; i++) {
            int randomGeneIndex = r.nextInt(geneList.size());
            City gene = geneList.get(randomGeneIndex);
            setGene(gene, i);
            geneList.remove(randomGeneIndex);
        }
    }

    public void setGene(City gene, int index){
        genes[index] = gene;
        fitness = 0;
    }

    public void setGenes(City[] genes){
        this.genes = genes;
    }

    public void setGenepool(City[] genepool) {
        this.genepool = genepool;
    }

    public double calculateFitness(){
        this.fitness = FitnessCalculator.calculate(this);
        return fitness;
    }

    public City[] getGenes() {
        return genes;
    }
    public City getGene(int index){
        return genes[index];
    }
    public int getGeneLength() {
        return geneLength;
    }
    public City[] getGenepool() {
        return genepool;
    }

    public String toString(){
        String s_genes = Arrays.toString(getGenes()).replace(",", "").replace("[", "").replace("]", "").replace(" ","");
        return "{fitness: " + fitness + ", genes: " + s_genes + "}";
    }
}
