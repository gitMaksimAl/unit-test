"""
GB Seminar Unit Test. Homework 6
"""
import sys
from typing import Collection


class ComparableList:
    """
    Class for working with arrays of data to be compared
    """

    def __init__(self, array: Collection[int | float | str]):
        self._array = array
        self._length = len(self._array)
        self._sum = 0
        self._get_mean()
        self._mean = 0 if self._length == 0 else self._sum / self._length

    def _get_mean(self):
        """
        Private method for average calculate
        :return: None
        """
        for x in self._array:
            if isinstance(x, str):
                try:
                    self._sum += ord(x[0])
                except IndexError:
                    print(f'Have empty string in collection{self._array}.',
                          file=sys.stderr)
                    sys.exit(1)
            else:
                self._sum += x

    @property
    def mean(self) -> int | float:
        """
        Average of elements
        :return: int | float
        """
        return self._mean

    @property
    def sum(self) -> int | float:
        """
        Summ of elements
        :return: int | float
        """
        return self._sum

    @property
    def length(self):
        """
        ComparableList length
        :return: int
        """
        return self._length


class ListsComparator:
    """
    Class with methods to compare 'ComparableList'
    """

    @staticmethod
    def compare_by_mean(list_one: ComparableList,
                        list_two: ComparableList) -> str:
        """
        The method displays which list of the two is larger than the average.
        :param list_one: ComparableList
        :param list_two: ComparableList
        :return: string
        """
        if not isinstance(list_one, ComparableList) \
                or not isinstance(list_two, ComparableList):
            raise TypeError
        if list_one.mean > list_two.mean:
            return "Первый список имеет большее среднее значение"
        if list_one.mean < list_two.mean:
            return "Второй список имеет большее среднее значение"
        return "Средние значения равны"
