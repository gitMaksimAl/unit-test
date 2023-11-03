"""
ListsComparator adapter for collect list of any
"""
from typing import Any

from ListsComparator import ComparableList


class ListCollector:
    """
    Collector of the list with static methods
    """

    @staticmethod
    def get_collection_from_console() -> ComparableList:
        """
        Get collection from input line
        :return: ComparableList
        """
        input_line = input('Please enter line of any: ')
        return ComparableList(ListCollector.make_collection(input_line))

    @staticmethod
    def make_collection(line: str) -> list[Any]:
        """
        Parse string to items, if not have items return empty list
        :param line: string with numbers or words
        :return: list
        """
        collection = []
        for item in ListCollector.parse_line(line):
            if item.isdecimal():
                collection.append(int(item))
            elif item.startswith('-') and item[1:].isdecimal():
                collection.append(int(item))
            else:
                try:
                    collection.append(float(item))
                except ValueError:
                    collection.append(item)
        return collection

    @staticmethod
    def parse_line(line: str) -> list[str]:
        """
        Spit strings array by space
        :param line: Any string
        :return: list
        """
        if len(line) > 0:
            line = line.replace(', ', ' ')
            collection = line.split(' ')
            return collection
        return []
