import java.util.*;

public class Backpack {
    private static final List<Item> ITEMS = new ArrayList<>();
    private static final Map<Integer, Backpack> CACHE = new HashMap<>();
    private static final boolean FINITE_ITEMS = true; //whether an item can be added more than once


    private int maxWeight;
    private List<Item> content;
    private int fullPrice;
    private int currentWeight;
    private int currentPrise;


    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
        content = new ArrayList<>();
        fullPrice=0;
        currentWeight =0;
    }

    public Backpack(int currentWeight, int currentPrise) {
        this.currentWeight = currentWeight;
        this.currentPrise = currentPrise;
    }

    public boolean putItem(Item item){
        if (currentWeight+item.getWeight() <= maxWeight) {
            content.add(item);
            currentWeight=+item.getWeight();
            fullPrice=+item.getPrice();
            return true;
        }
        return false;
    }

    public static void fillBackpack(List<Item> items, Backpack backpack){

    }

    public static Backpack bestBagForCapa(int capa) {
        if (CACHE.containsKey(capa)) return CACHE.get(capa);
        if (capa < 0) return null;
        if (capa == 0) return new Backpack(0, 0);

        int currentWeight = -1;
        int currentValue = -1;
        String newItem = null;
        List<Item> previousItems = null;
        for (Item p : ITEMS) {
            Backpack previous = bestBagForCapa(capa - p.getWeight());
            if (previous == null) continue;

            int weightSoFar = previous.currentWeight;
            int valueSoFar = previous.currentPrise;
            int nextBestValue = 0;
            Item candidateItem = null;
            for (Item candidate : ITEMS) {
                if (FINITE_ITEMS && previous.content.contains(candidate)) continue;
                if (weightSoFar + candidate.getWeight() <= capa && nextBestValue < valueSoFar + candidate.getPrice()) {
                    candidateItem = candidate;
                    nextBestValue = valueSoFar + candidate.getPrice();
                }
            }

            if (candidateItem != null && nextBestValue > currentValue) {
                currentValue = nextBestValue;
                currentWeight = weightSoFar + candidateItem.getWeight();
                newItem = candidateItem.getName();
                previousItems = previous.content;
            }
        }

        if (currentWeight <= 0 || currentValue <= 0) throw new RuntimeException("cannot be 0 here");
        Backpack bestBag = new Backpack(currentWeight, currentValue);
        bestBag.add(previousItems);
        bestBag.add(Collections.singletonList(newItem));
        CACHE.put(capa, bestBag);
        return bestBag;
    }

}
}
