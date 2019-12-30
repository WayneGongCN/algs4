/**
 * Union-Find 初级简洁实现（quick-find）
 */
public class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int find(int p) {
        return id[p];
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind uf = new QuickFind(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
