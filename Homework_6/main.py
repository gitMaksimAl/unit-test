from ListsComparator import ListsComparator, ComparableList
from ListCollector import ListCollector


if __name__ == "__main__":
    list_one = ListCollector.get_collection_from_console()
    list_two = ListCollector.get_collection_from_console()
    print(ListsComparator.compare_by_mean(list_one, list_two))
