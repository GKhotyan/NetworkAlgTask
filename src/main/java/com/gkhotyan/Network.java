package com.gkhotyan;

public class Network {
    private int[] elements;

    /**
     * Initializes an empty network structure with n elements.
     * Each site is initially in its own component.
     *
     * @param  n the number of elements
     * @throws IllegalArgumentException if {@code n <= 0}
     */
    public Network(int n) {
        if(n<1)
            throw new IllegalArgumentException("The number of elements should be positive");
        elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i;
        }
    }

    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param  p the integer representing one object
     * @return the component identifier for the component containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p <= n}
     */
    private int find(int p) throws IllegalArgumentException {
        validate(p);
        p--;
        while (p != elements[p])
            p = elements[p];
        return p;
    }

    // validate that p is a valid element
    private void validate(int p) throws IllegalArgumentException{
        int n = elements.length;
        if (p < 1 || p > n) {
            throw new IllegalArgumentException("Element " + p + " should be between 1 and " + n);
        }
    }

    /**
     * Returns true if the the two elements are query.
     *
     * @param  p first element
     * @param  q second element
     * @return true if the elements query;
     *         false otherwise
     * @throws IllegalArgumentException unless
     *         both (0 < p <= n) and (0 < q <= n)
     */
    public boolean query(int p, int q) throws IllegalArgumentException{
        return find(p) == find(q);
    }


    /**
     * Merges the component containing element p with the
     * the component containing element q.
     *
     * @param  p first element
     * @param  q second element
     * @throws IllegalArgumentException unless
     *         both (0 < p <= n) and (0 < q <= n)
     */
    public void connect(int p, int q) throws IllegalArgumentException{
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        elements[rootP] = rootQ;
    }

}
