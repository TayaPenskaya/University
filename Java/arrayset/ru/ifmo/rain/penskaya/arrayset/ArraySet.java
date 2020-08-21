package ru.ifmo.rain.penskaya.arrayset;

import java.util.*;

public class ArraySet<E> extends AbstractSet<E> implements SortedSet<E> {
    private List<E> elements;
    private Comparator<? super E> comparator;

    public ArraySet() {
        this(Collections.emptyList(), null);
    }

    public ArraySet(Comparator<? super E> newComparator) {
        this(Collections.emptyList(), newComparator);
    }

    public ArraySet(Collection<? extends E> collection) {
        this(collection, null);
    }

    public ArraySet(Collection<? extends E> container, Comparator<? super E> comparator) {
        this.comparator = comparator;
        Set<E> tree = new TreeSet<>(comparator);
        tree.addAll(container);
        this.elements = new ArrayList<>(tree);
    }

    private ArraySet(List<E> elements, Comparator<? super E> comparator) {
        this.elements = elements;
        this.comparator = comparator;
    }

    @Override
    public Iterator<E> iterator() {
        return Collections.unmodifiableList(elements).iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return Collections.binarySearch(elements, (E) Objects.requireNonNull(o), comparator) >= 0;
    }

    @Override
    public Comparator<? super E> comparator() {
        return comparator;
    }

    @Override
    public E first() {
        if (isEmpty())
            throw new NoSuchElementException();
        return elements.get(0);
    }

    @Override
    public E last() {
        if (isEmpty())
            throw new NoSuchElementException();
        return elements.get(elements.size() - 1);
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        if (comparator == null) {
            Comparable fromE = (Comparable) fromElement;
            Comparable toE = (Comparable) toElement;
            if (fromE.compareTo(toE) > 0) {
                throw new IllegalArgumentException("The left border should be less or equal than right");
            }
        } else {
            if (comparator.compare(fromElement, toElement) > 0) {
                throw new IllegalArgumentException("The left border should be less or equal than right");
            }
        }
        if (isEmpty()) return new ArraySet<>(Collections.emptyList(), comparator);
        int from = findIndex(fromElement, true, true);
        int to = findIndex(toElement, false, false);
        return new ArraySet<>(elements.subList(from, to), comparator);
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        if (isEmpty()) return new ArraySet<>(Collections.emptyList(), comparator);
        return new ArraySet<>(elements.subList(0, findIndex(toElement, false, false)), comparator);
        //return subSet(first(), toElement);
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        if (isEmpty()) return new ArraySet<>(Collections.emptyList(), comparator);
        return new ArraySet<>(elements.subList(findIndex(fromElement, true, false), elements.size()), comparator);
    }

    public int findIndex(E element, boolean inclusive, boolean from) {
        int ind = Collections.binarySearch(elements, element, comparator);
        if (ind < 0) {
            ind = -ind - 1;
        } else if (!inclusive) {
            if (from) {
                ++ind;
            }
        }
        return ind;
    }
}

//java -cp . -p . -m info.kgeorgiy.java.advanced.arrayset SortedSet ru.ifmo.rain.penskaya.arrayset.ArraySet