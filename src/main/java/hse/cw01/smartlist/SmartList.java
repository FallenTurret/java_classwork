package hse.cw01.smartlist;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SmartList<E> extends AbstractList<E> implements List<E> {

    private int size = 0;
    private Object data;

    public SmartList() {
        data = null;
    }

    public SmartList(Collection<? extends E> collection) {
        int collectionSize = collection.size();
        if (collectionSize == 0) {
            data = null;
        } else if (collectionSize == 1) {
            data = collection.toArray()[0];
        } else if (collectionSize <= 5) {
            data = collection.toArray();
        } else {
            data = new ArrayList(collection);
        }
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        if (size == 1) {
            return (E) data;
        } else if (size <= 5) {
            return ((E[]) data)[index];
        } else {
            return ((ArrayList<E>) data).get(index);
        }
    }

}