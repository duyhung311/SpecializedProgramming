package block4.CellRemoval;

public class CellRemoval {
    class Iteration {
        int leafNode =0;
        int cnt = 0;

        @Override
        public String toString() {
            return "Iteration{" +
                    "leafNode=" + leafNode +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    int total;
    int cellsLeft(int[] parent, int deletedCell) {
        total = parent.length;
        Iteration i = new Iteration();
        int c = count(i, deletedCell);
        System.out.println(c+1);
        System.out.println(i);
        return total - c  -1;
    }
    int count(Iteration i, int deletedCell) {
        if (deletedCell > total) {
//            i.leafNode++;
            return i.cnt;
        }

        int leftChild = getLeftChildFromHeap(deletedCell);
        if (leftChild < total) {
            i.cnt++;
            count(i, leftChild);
        } else {
            count(i, leftChild);

        }


        int rightChild = getRightChildFromHeap(deletedCell);
        if (rightChild < total) {
            i.cnt++;
            return count(i, rightChild);
        } else {
            return count(i, rightChild);

        }

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
