import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    @Test
    void emptyTreeHasExpectedHeightAndSearchResult() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertTrue(bst.isEmpty());
        assertEquals(0, bst.size());
        assertEquals(-1, bst.height());

        BinarySearchTree.SearchResult result = bst.findWithCount(32);
        assertFalse(result.isFound());
        assertEquals(0, result.getNodesVisited());
    }

    @Test
    void singleNodeTreeHasZeroEdgeHeightAndOneVisitOnHit() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertTrue(bst.insert(50));

        assertFalse(bst.isEmpty());
        assertEquals(1, bst.size());
        assertEquals(0, bst.height());

        BinarySearchTree.SearchResult hit = bst.findWithCount(50);
        assertTrue(hit.isFound());
        assertEquals(1, hit.getNodesVisited());

        BinarySearchTree.SearchResult miss = bst.findWithCount(25);
        assertFalse(miss.isFound());
        assertEquals(1, miss.getNodesVisited());
    }

    @Test
    void insertsInOrderAndTracksSearchDepth() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int k : keys) {
            assertTrue(bst.insert(k));
        }

        assertEquals(7, bst.size());
        assertEquals(2, bst.height());

        assertEquals(1, bst.findWithCount(50).getNodesVisited());
        BinarySearchTree.SearchResult leafSearch = bst.findWithCount(20);
        assertTrue(leafSearch.isFound());
        assertEquals(3, leafSearch.getNodesVisited());
    }

    @Test
    void duplicateInsertionsAreIgnored() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertTrue(bst.insert(10));
        assertFalse(bst.insert(10));
        assertEquals(1, bst.size());
        assertEquals(0, bst.height());
    }

    @Test
    void experimentRunnerProducesPositiveMetrics() {
        BSTExperimentRunner runner = new BSTExperimentRunner(12345L);
        BSTExperimentRunner.TrialSummary summary = runner.runExperiment(50, 1_000, 5);

        assertEquals(50, summary.getTargetCount());
        assertEquals(5, summary.getTrials());
        assertTrue(summary.getAverageHeight() > 0);
        assertTrue(summary.getAverageNodesPerFind() >= 1.0);
    }
}