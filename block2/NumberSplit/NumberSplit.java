
public class NumberSplit {

    /*
    We start with an integer and create a sequence of successors using the following procedure: First split the decimal representation of the given number into several (at least two) parts, and multiply the parts to get a possible successor. With the selected successor, we repeat this procedure to get a third number, and so on, until we reach a single-digit number.

    For example, let's say we start with the number 234. The possible successors are:

    - 23 * 4 = 92,
    - 2 * 34 = 68 and
    - 2 * 3 * 4 = 24.
    If we select 68 as the successor, we then generate 6 * 8 = 48 (the only possibility), from this we generate 4 * 8 = 32 and finally 3 * 2 = 6. With this selection, we have generated a sequence of 5 integers (234, 68, 48, 32, 6).
    Given the starting number, start, return the length of the longest sequence that can be generated with this procedure. In the example, the given sequence would be the longest one since the other selections in the first step would give the sequences: (234, 92, 18, 8) and (234, 24, 8), which are both shorter than (234, 68, 48, 32, 6).


     */
    int longestSequence(int start) {
        if (start < 10) {
            return 1;
        }
        return 1;
    }

    void longestSequenceRecursive(int start) {

    }
}
