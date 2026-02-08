import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


abstract class Animal {
    public abstract String toString();
}


class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}


public class Ecosystem {
    private Animal[] river;
    private Random random;

   
    private static final int DEFAULT_BEAR_COUNT = 5;
    private static final int DEFAULT_FISH_COUNT = 7;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        populate(DEFAULT_BEAR_COUNT, DEFAULT_FISH_COUNT);
    }


    public Ecosystem(int riverSize, int numBears, int numFish) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        populate(numBears, numFish);
    }

    private void populate(int numBears, int numFish) {
     
        for (int i = 0; i < numBears; i++) {
            placeRandomEmpty(new Bear(), river);
        }
        
        for (int i = 0; i < numFish; i++) {
            placeRandomEmpty(new Fish(), river);
        }
    }

    private boolean placeRandomEmpty(Animal a, Animal[] arr) {
        List<Integer> empty = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) empty.add(i);
        }
        if (empty.isEmpty()) return false;
        int idx = empty.get(random.nextInt(empty.size()));
        arr[idx] = a;
        return true;
    }

    public void runStep() {
        Animal[] next = new Animal[river.length];

       
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < river.length; i++) indices.add(i);
        Collections.shuffle(indices, random);

        int bearBirths = 0;
        int fishBirths = 0;

        for (int i : indices) {
            Animal current = river[i];
            if (current == null) continue;

            int target = pickMove(i);

            
            if (next[target] == null) {
                next[target] = current;
                continue;
            }

        
            Animal existing = next[target];

           
            if (current.getClass() == existing.getClass()) {
                if (current instanceof Bear) bearBirths++;
                else if (current instanceof Fish) fishBirths++;
                
            }
           
            else {
                if (current instanceof Bear || existing instanceof Bear) {
                    next[target] = new Bear(); // ensure bear remains
                } else {
                  
                    next[target] = existing;
                }
            }
        }

       
        for (int k = 0; k < bearBirths; k++) placeRandomEmpty(new Bear(), next);
        for (int k = 0; k < fishBirths; k++) placeRandomEmpty(new Fish(), next);

       
        river = next;
    }

    
    private int pickMove(int i) {
        int delta = random.nextInt(3) - 1; // -1, 0, +1
        int t = i + delta;
        if (t < 0) t = 0;
        if (t >= river.length) t = river.length - 1;
        return t;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20); // river size 20
        eco.visualize();

     
        for (int step = 1; step <= 30; step++) {
            eco.runStep();
            eco.visualize();

           
            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        }
    }
}

