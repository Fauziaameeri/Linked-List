import java.util.*;

public class ToyStoreManager {
    private ToyNode store;

    public ToyStoreManager(String toys) {
        if (toys.isEmpty()) {
            throw new IllegalArgumentException();
        }
        else {
            String[] toys1 = toys.split(" ");
            for (String toyString : toys1) {
                String[] toyPricePair = toyString.split("-");
                String name = toyPricePair[0];
                double price = Double.parseDouble(toyPricePair[1]);

                // if (store == null) {
                //     ToyNode startNode = new ToyNode(name,price,1,null);
                //     store = startNode;
                // }

                ToyNode toy = findToy(name);

                if (toy == null) {
                    ToyNode newNode = new ToyNode(name,price,1,null);
                    newNode.setNext(store);
                    store = newNode;
                    //put(new Toy(name, price), 1);
                }
                else {
                    //System.out.println("count++");
                    toy.setCount(toy.getCount()+1);
                    //this.store.put(toy, this.store.get(toy) + 1);
                }
                //System.out.println(store.getName());
            }
        }
    }
    public ToyNode findToy(String toyName) {
        ToyNode selectedToy = store;
        while (selectedToy != null) {
            if (selectedToy.getName().equals(toyName)) {
                return selectedToy;
            }
            selectedToy = selectedToy.getNext();
        }
        return selectedToy;
    }
    public String getMostFrequentToy() {
        ToyNode current = store;
        int count = 0;
        if (current == null) {
            return "No toy in the store";
        }
        while (current != null) {
            count = Math.max(count, (int)current.getCount());
            current = current.getNext();
        }
        current = store;
        while (current.getCount() != count) {

            current = current.getNext();
        }
        return current.getName();
    }

    public String toString(){
        ToyNode current = store;
        ArrayList<String> outPut = new ArrayList<String>();
        while (current != null) {
            outPut.add(current.toString());
            current = current.getNext();
        }

        return "[" + String.join(", ", outPut) + "]";
    }
}
