import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Individual {

    private final int geneLength;
    private final char[] genes;
    private int fitness = 0;

    public Individual(int geneLength){
        this.geneLength = geneLength;
        genes = new char[geneLength];
        generateGenes();
    }

    private void generateGenes(){
        Random r = new Random();
        for(int i=0; i!=geneLength; i++) {
            boolean isUnique = false;
            char gene = 0;
            while (!isUnique) {
                gene = (char) (r.nextInt(26) + 'a');
                if(!contains(genes, gene)){
                    isUnique = true;
                }
            }
            setGene(gene, i);
        }
    }

    public static boolean contains(char[] array, char v) {
        for (char e : array)
            if (Objects.equals(v, e))
                return true;
        return false;
    }

    public void setGene(char gene, int index){
        genes[index] = gene;
        fitness = 0;
    }

    /*public int calculateFitness(){
        this.fitness = FitnessCalculator.calculate(this);
        return this.fitness;
    }
     */

    public char[] getGenes() {
        return genes;
    }

    public char getGene(int index){
        return genes[index];
    }

    public int getFitness() {
        return fitness;
    }

    public String toString(){
        String s_genes = Arrays.toString(getGenes()).replace(",", "").replace("[", "").replace("]", "").replace(" ","");
        return "{fitness: " + fitness + ", genes: " + s_genes + "}";
    }
}
