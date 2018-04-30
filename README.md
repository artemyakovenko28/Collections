# Collections
Considered collections hierarchy, `ArrayList`, `LinkedList`, `HashSet`, `TreeSet`, `HashMap`, `TreeMap`, computational complexity, overriding `equals()` and `hashcode()`
## Tasks
### Equals() and hashCode()
`src/labs/equals_hashCode_toString`
There are EntityA, EntityB, EntityC:
```java
public class EntityA {
    private int age;
    private int height;
    private String name;
}
```
```java
public class EntityB {
    private final String[][] stringArr;
    private final double[] doubleArr;
}
```
```java
public class EntityC {
    private final EntityA entity;
    private final List<EntityB> list;
    private final Map<Set<EntityA>, List<EntityB[]>> map;
}
```
Override `equals()`, `hashcode()` and `toString()` correctly for EntityA, EntityB, EntityC
### List
`src/labs/List_ArrayList_LinkedList`
Create implementations of `ArrayList` and `LinkedList` with such methods:
- add(T element)
- add(int index, T element)
- get(int index)
- iterator()
- contains(T element)
- size()
- isEmpty()
- set(int index, T element)
- remove(T element)
- remove(int index)
- equals(Object obj)
- hashCode()
- toString()
### Iterable and Iterator
`src/labs/Iterable_Iterator`
- Write an iterator that returns squares of integers
- Write method that merges two iterable
`src/labs/Iterable_Iterator\InputStream_Iterator`
- Implement adapter InputStream to Iterator
