import java.awt.geom.Point2D;

public class FitnessCalculator {


    static City[] solution;

    public static void setProblem(City[] newSolution){
        solution = newSolution;
    }

    static double calculate(Individual individual){
        double fitness = 0;
        for(int i=0; i!=solution.length-1; i++){
            fitness += individual.getGene(i).distanceTo(individual.getGene(i+1));
        }
        return fitness;
    }

}
