import java.util.*;


    class ReversIterator implements Iterator {
        private List collection;
        private int counter;

        public ReversIterator(List collection) {
            this.collection = collection;
            this.counter = collection.size();
        }

        @Override
        public boolean hasNext() {
            return counter > 0 && counter <= collection.size();
        }

        @Override
        public Object next() {
            counter--;
            return collection.get(counter);
        }
    }




