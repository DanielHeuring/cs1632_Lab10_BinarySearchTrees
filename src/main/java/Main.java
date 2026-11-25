import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        int[] sampleSizes = {100, 1000, 10000};
        int trialsPerSize = 10;
        int rangeK = 100000;

        BSTExperimentRunner runner = new BSTExperimentRunner();

        // Google. (2026). Gemini (Gemini 3.1 Pro) [Large language model]. https://gemini.google.com
        // To help format the output to look nice

        System.out.printf(
                Locale.US,
                "%-10s %-10s %-10s %-18s %-24s%n",
                "N", "Trials", "Range K", "Avg Tree Height", "Avg Nodes / Find");
        System.out.println("---------------------------------------------------------------------------");

        for (int n : sampleSizes) {
            BSTExperimentRunner.TrialSummary summary = runner.runExperiment(n, rangeK, trialsPerSize);
            System.out.printf(
                    Locale.US,
                    "%-10d %-10d %-10d %-18.2f %-24.4f%n",
                    summary.getTargetCount(),
                    summary.getTrials(),
                    summary.getMaxRangeK(),
                    summary.getAverageHeight(),
                    summary.getAverageNodesPerFind()
            );
        }
    }
}