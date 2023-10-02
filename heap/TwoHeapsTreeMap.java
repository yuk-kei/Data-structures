package heap;

import java.util.TreeMap;

public class TwoHeapsTreeMap {
    private final TreeMap<Integer, Integer> small, large;
    private int smallSize, largeSize;

    public TwoHeapsTreeMap() {
        small = new TreeMap<>();
        large = new TreeMap<>();
        smallSize = 0;
        largeSize = 0;
    }

    public void add(int num) {
        if (smallSize == 0 || num <= small.lastKey()) {
            small.put(num, small.getOrDefault(num, 0) + 1);
            smallSize++;
        } else {
            large.put(num, large.getOrDefault(num, 0) + 1);
            largeSize++;
        }
        rebalanced();
    }

    private void rebalanced(){
        while (smallSize > largeSize + 1) {
            large.put(small.lastKey(), large.getOrDefault(small.lastKey(), 0) + 1);
            small.put(small.lastKey(), small.get(small.lastKey()) - 1);
            if (small.get(small.lastKey()) == 0) {
                small.remove(small.lastKey());
            }
            smallSize--;
            largeSize++;
        }
        while(smallSize < largeSize) {
            small.put(large.firstKey(), small.getOrDefault(large.firstKey(), 0) + 1);
            large.put(large.firstKey(), large.get(large.firstKey()) - 1);
            if (large.get(large.firstKey()) == 0) {
                large.remove(large.firstKey());
            }
            smallSize++;
            largeSize--;
        }
    }

    public boolean remove(int num) {
        if (small.containsKey(num)) {

            if (small.get(num) == 1) {
                small.remove(num);
            } else {
                small.put(num, small.get(num) - 1);
            }
            smallSize--;
            return true;

        } else if (large.containsKey(num)) {

            if (large.get(num) == 1) {
                large.remove(num);
            } else {
                large.put(num, large.get(num) - 1);
            }
            largeSize--;
            return true;
        }
        return false;
    }

    public double getMedian() {
        if (smallSize == largeSize) {
            return ((double)small.lastKey() + (double)large.firstKey()) / 2;
        } else {
            return small.lastKey();
        }
    }

    public int getSize(){
        return smallSize + largeSize;
    }
}
