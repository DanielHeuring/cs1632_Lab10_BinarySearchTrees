import java.util.Random;

public class BSTExperimentRunner {

    public static final class TrialSummary {
        private final int targetCount;
        private final int trials;
        private final int maxRangeK;
        private final double averageHeight;
        private final double averageNodesPerFind;

        public TrialSummary(
                int targetCount,
                int trials,
                int maxRangeK,
                double averageHeight,
                double averageNodesPerFind) {
            this.targetCount = targetCount;
            this.trials = trials;
            this.maxRangeK = maxRangeK;
            this.averageHeight = averageHeight;
            this.averageNodesPerFind = averageNodesPerFind;
        }

        public int getTargetCount() {
            return targetCount;
        }

        public int getTrials() {
            return trials;
        }

        public int getMaxRangeK() {
            return maxRangeK;
        }

        public double getAverageHeight() {
            return averageHeight;
        }

        public double getAverageNodesPerFind() {
            return averageNodesPerFind;
        }
    }

    private final Random random;

    public BSTExperimentRunner(long n) {
        this.random = new Random(n);
    }

    public BSTExperimentRunner() {
        this.random = new Random();
    }

    public TrialSummary runExperiment(int countN, int maxRangeK, int trials) {
        if (countN <= 0) {
            throw new IllegalArgumentException("countN must be positive");
        }
        if (maxRangeK < 1) {
            throw new IllegalArgumentException("maxRangeK must be at least 1");
        }
        if (trials <= 0) {
            throw new IllegalArgumentException("trials must be positive");
        }

        long totalHeight = 0;
        long totalFindVisits = 0;
        long totalFindsPerformed = 0;

        for (int i = 0; i < trials; i++) {
            BinarySearchTree<Integer> bst = new BinarySearchTree<>();
            int[] insertedValues = new int[countN];

            for (int j = 0; j < countN; j++) {
                int value = random.nextInt(maxRangeK) + 1; // 1 .. maxRangeK
                insertedValues[j] = value;
                bst.insert(value);
            }

            totalHeight += bst.height();

            for (int value : insertedValues) {
                BinarySearchTree.SearchResult result = bst.findWithCount(value);
                totalFindVisits += result.getNodesVisited();
                totalFindsPerformed++;
            }
        }

        double avgHeight = (double) totalHeight / trials;
        double avgNodesPerFind = (double) totalFindVisits / totalFindsPerformed;
        return new TrialSummary(countN, trials, maxRangeK, avgHeight, avgNodesPerFind);
    }
}