
public class ProblemsToSolve {
    public int minNumber(int[] pleasantness, int variety) {
        int ret = pleasantness.length;

        for (int i = 1; i < pleasantness.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (Math.abs(pleasantness[i] - pleasantness[j]) >= variety) {
                    ret = Math.min(doProblem(i, j), ret);
                    found = true;
                }
            }
            if (found)
                break;
        }
        return ret;
    }

    private int doProblem(int curProblem, int curPleasantness) {
        int ret = 0;

        ret += 2;
        ret += (curPleasantness - curProblem - 1) / 2;

        if (curProblem != 0) {
            ret++;
            ret += (curProblem - 1) / 2;
        }

        return ret;
    }
}
