/**
 * Union-Find 初级简洁实现（quick-find）
 */
public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int N) {
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
        int pid = root(p);
        int qid = root(q);
        id[pid] = qid;
        count--;
    }

    public boolean connected(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        return pid == qid;
    }

    public int root(int p) {
        int pid = id[p];
        while (pid != p) {
            pid = id[pid];
        }
        return pid;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UnionFind uf = new UnionFind(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
        }
        StdOut.println(uf.count() + " components");
    }
}
