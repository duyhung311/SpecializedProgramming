package block4.CellRemoval;

public class CellRemoval {
    int total;
    int cellsLeft(int[] parent, int deletedCell) {
        total = parent.length;
        int c = 0;
         count(c, deletedCell);
        return total - c  -1;
    }
    void count(int cnt, int deletedCell) {
        if (deletedCell > total) {
            return;
        }

        int leftChild = getLeftChildFromHeap(deletedCell);
        count(++cnt, leftChild);


        int rightChild = getRightChildFromHeap(deletedCell);
        count(++cnt, rightChild);

//        cnt += (leftChild < total) ? 1 : 0;
//        cnt += (rightChild < total) ? 1 : 0;
//        if (leftChild >= total || rightChild >= total) {
//            return cnt;
//        } else {
//            return count(cnt, leftChild) + count(cnt, rightChild);
//        }
    }

    int getLeftChildFromHeap(int parentIndex) {
        return (parentIndex * 2) + 1;
//        int forecastLeftChild = (parentIndex * 2) + 1;
//        if (forecastLeftChild < total)
//            return 1;
//        return 0;
    }
    int getRightChildFromHeap(int parentIndex) {
        return (parentIndex * 2) + 2;
//        int forecastLeftChild = (parentIndex * 2) + 2;
//        if (forecastLeftChild < total)
//            return 1;
//        return 0;
    }

    int getParentFromHeap(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public static void main(String[] args) {
        int[] parent = {-1,0,0,1,1};
        System.out.println(new CellRemoval().cellsLeft(parent, 1));
    }
}
