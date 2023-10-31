"""
Unit test for function compare_by_mean
"""
import pytest
from ListsComparator import ListsComparator, ComparableList
from ListCollector import ListCollector


def test_integer_lists():
    """
    Test function compare_by_mean on integer lists
    :return: None
    """
    list1 = ComparableList([1, 2, 3, 4, 5])
    list2 = ComparableList([-3, 0, 4, 9, 1])
    assert ListsComparator.compare_by_mean(list2, list1) \
        == "Второй список имеет большее среднее значение"
    assert ListsComparator.compare_by_mean(list1, list1) \
        == "Средние значения равны"


def test_float_lists():
    """
    Test function compare_by_mean on float lists
    :return: None
    """
    list1 = ComparableList([12.2, 7.23, 5.1, 3.3, 0.27, -1.8])
    list2 = ComparableList([5.5, 30.07, 24.4, 0.97, -3.3, 0, 6.11])
    assert ListsComparator.compare_by_mean(list2, list1) \
        == "Первый список имеет большее среднее значение"
    assert ListsComparator.compare_by_mean(list1, list1) \
        == "Средние значения равны"


def test_string_list():
    """
    Test function compare_by_mean on string lists
    :return: None
    """
    list1 = ComparableList(["int", "float", "string", "double"])
    list2 = ComparableList(["int", "double", "float", "string", "double"])
    assert ListsComparator.compare_by_mean(list1, list2) \
        == "Первый список имеет большее среднее значение"
    assert ListsComparator.compare_by_mean(list1, list1) \
        == "Средние значения равны"


def test_empty_list():
    """
    Test function compare_by_mean with empty lists
    :return: None
    """
    list1 = ComparableList(["int", "float", "string", "double"])
    list2 = ComparableList([])
    assert ListsComparator.compare_by_mean(list1, list2) \
        == "Первый список имеет большее среднее значение"
    assert ListsComparator.compare_by_mean(list2, list2) \
           == "Средние значения равны"


def test_bool_list():
    """
    Test function compare_by_mean on boolean lists
    :return: None
    """
    list1 = ComparableList([True, True, True, False, False])
    list2 = ComparableList([False, True, True, False, False])
    assert ListsComparator.compare_by_mean(list1, list2) \
           == "Первый список имеет большее среднее значение"


def test_type_error():
    """
    Test function compare_by_mean on Exception
    :return: None
    """
    list1 = (1, 2, 3, 4, 5, 6)
    list2 = (3, 2, 3, 4, -9, 6)
    with pytest.raises(TypeError):
        ListsComparator.compare_by_mean(list1, list2)


def test_exit_one():
    """
    Test function compare_by_mean with empty string in items
    :return: None
    """
    with pytest.raises(SystemExit) as ex:
        list1 = ComparableList(['solo', 'hard', 'copy', ''])
    assert ex.type == SystemExit
    assert ex.value.code == 1


def test_collector():
    """
    Test for collector
    :return: None
    """
    assert all(isinstance(i, int)
               for i in ListCollector.make_collection("122, -32, 0, 4"))
    assert all(isinstance(i, str)
               for i in ListCollector.make_collection("foo, bar, gold, bank"))
    assert all(isinstance(i, float)
               for i in ListCollector.make_collection("3.3, -1.28, 0.75, 2.03"))


def test_parser():
    """
    Test for string parser
    :return: None
    """
    assert len(ListCollector.parse_line("foo, bar, fizz, buzz")) == 4
    assert len(ListCollector.parse_line("")) == 0
    assert len(ListCollector.parse_line("1 2 3 4")) == 4
    assert len(ListCollector.parse_line("1 2 3 4 ")) == 5
