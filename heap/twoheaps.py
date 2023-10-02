import heapq


class MedianFinder:

    def __init__(self):
        self.small, self.large = [], []
        self.small_size, self.large_size = 0, 0
        self.deleted = {}

    def add(self, num):
        if self.small and -self.small[0] >= num:
            heapq.heappush(self.small, -num)
            self.small_size += 1
        else:
            heapq.heappush(self.large, num)
            self.large_size += 1

        self._balance_heaps()

    def get_median(self):
        self._lazy_delete()

        if self.small_size == self.large_size:
            return (self.large[0] + (-self.small[0])) / 2.0
        else:
            return -self.small[0]

    def remove(self, num):
        if -self.small[0] >= num:
            self.small_size -= 1
        else:
            self.large_size -= 1

        curr = self.deleted.get(num, 0)
        self.deleted[num] = curr + 1

        self._lazy_delete()
        self._balance_heaps()

    def get_size(self):
        return self.small_size + self.large_size

    def _lazy_delete(self):
        # Ensure that the heaps are not empty when accessing their top
        while self.small and self.deleted.get(-self.small[0], 0):
            self.deleted[-self.small[0]] -= 1
            if self.deleted[-self.small[0]] == 0:
                del self.deleted[-self.small[0]]
            heapq.heappop(self.small)

        while self.large and self.deleted.get(self.large[0], 0):
            self.deleted[self.large[0]] -= 1
            if self.deleted[self.large[0]] == 0:
                del self.deleted[self.large[0]]
            heapq.heappop(self.large)

    def _balance_heaps(self):
        while self.small_size > self.large_size + 1:
            heapq.heappush(self.large, -heapq.heappop(self.small))
            self.small_size -= 1
            self.large_size += 1

        while self.large_size > self.small_size:
            heapq.heappush(self.small, -heapq.heappop(self.large))
            self.large_size -= 1
            self.small_size += 1
