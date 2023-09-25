class MyHashMap:

    def __init__(self):
        self.map = [ListNode(0, 0) for _ in range(10 ** 4)]
        self.size = len(self.map)

    def put(self, key: int, value: int) -> None:
        curr = self.map[key % self.size]

        while curr.next:
            if curr.next.key == key:
                curr.next.value = value
                return

            curr = curr.next

        curr.next = ListNode(key, value)

    def get(self, key: int) -> int:
        curr = self.map[key % self.size].next

        while curr:
            if curr.key == key:
                return curr.value

            curr = curr.next

        return -1

    def remove(self, key: int) -> None:
        curr = self.map[key % self.size]

        while curr.next:
            if curr.next.key == key:
                curr.next = curr.next.next
                return
            curr = curr.next


class ListNode:

    def __init__(self, key: int, value: int) -> None:
        self.key = key
        self.value = value
        self.next = None
