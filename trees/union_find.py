class UnionFind:

    def __init__(self, n: int):
        self.parent = {}
        self.rank = {}
        self.num_components = n

        for i in range(n):
            self.parent[i] = i
            self.rank[i] = 0

    def find(self, x: int) -> int:
        curr_par = self.parent[x]

        while curr_par != self.parent[curr_par]:
            self.parent[curr_par] = self.parent[self.parent[curr_par]]
            curr_par = self.parent[curr_par]

        return curr_par

    def isSameComponent(self, x: int, y: int) -> bool:
        return self.find(x) == self.find(y)

    def union(self, x: int, y: int) -> bool:
        x_par = self.find(x)
        y_par = self.find(y)
        if x_par == y_par:
            return False

        if self.rank[x_par] > self.rank[y_par]:
            self.parent[y_par] = x_par

        elif self.rank[x_par] < self.rank[y_par]:
            self.parent[x_par] = y_par

        else:
            self.parent[y_par] = x_par
            self.rank[x_par] += 1

        self.num_components -= 1
        return True

    def getNumComponents(self) -> int:

        return self.num_components
