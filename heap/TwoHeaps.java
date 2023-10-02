package heap;

import java.util.PriorityQueue;

public class TwoHeaps {
    private final PriorityQueue<Integer> small, large;
    public TwoHeaps(){
        small = new PriorityQueue<>((a,b) -> b -a);
        large = new PriorityQueue<>();
    }

    public void addNum(int num){
        if(small.isEmpty() || num <= small.peek()){
            small.add(num);
        } else {
            large.add(num);
        }

        rebalanced();
    }

    public double findMedian(){
        if(!small.isEmpty() && !large.isEmpty()){
            if(small.size() == large.size()){
                return ((double)small.peek() + (double)large.peek()) / 2.0;
            } else {
                return small.peek();
            }
        } else {
            return 0.0;
        }
    }

    private void rebalanced(){
        while(small.size() > large.size() + 1){
            large.add(small.poll());
        }
        while(small.size() < large.size()){
            small.add(large.poll());
        }
    }

    public boolean remove(int num){
        if(small.contains(num)){
            small.remove(num);
            rebalanced();
            return true;
        } else if(large.contains(num)){
            large.remove(num);
            rebalanced();
            return true;
        }
        return false;
    }
}
