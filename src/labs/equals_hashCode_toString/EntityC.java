package labs.equals_hashCode_toString;

import java.util.*;

public class EntityC {
    private final EntityA entity;
    private final List<EntityB> list;
    private final Map<Set<EntityA>, List<EntityB[]>> map;

    public EntityC(EntityA entity, List<EntityB> list, Map<Set<EntityA>, List<EntityB[]>> map) {
        this.entity = entity;
        this.list = list;
        this.map = map;
    }

    public EntityA getEntity() {
        return entity;
    }

    public List<EntityB> getList() {
        return list;
    }

    public Map<Set<EntityA>, List<EntityB[]>> getMap() {
        return map;
    }

    @Override
    public int hashCode() {
        int result = entity.hashCode();
        result = 31 * result + list.hashCode();
        for (Map.Entry<Set<EntityA>, List<EntityB[]>> pair : map.entrySet()) {
            result = 31 * result + pair.getKey().hashCode();
            List<EntityB[]> value = pair.getValue();
            for (EntityB[] elem : value) {
                result = 31 * result + Arrays.hashCode(elem);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        EntityC that = (EntityC) obj;
        if (!this.entity.equals(that.entity)) return false;
        if (!this.list.equals(that.list)) return false;
        if (this.map.size() != that.map.size()) return false;
        if (!this.map.keySet().equals(that.map.keySet())) return false;

        for (Map.Entry<Set<EntityA>, List<EntityB[]>> entry : map.entrySet()) {
            Set<EntityA> key = entry.getKey();
            List<EntityB[]> value = entry.getValue();
            if (value == null) {
                if (!(that.map.get(key) == null && that.map.containsKey(key)))
                    return false;
            } else {
                ListIterator<EntityB[]> e1 = value.listIterator();
                ListIterator<?> e2 = ((List<?>) that.map.get(key)).listIterator();
                while (e1.hasNext() && e2.hasNext()) {
                    EntityB[] o1 = e1.next();
                    EntityB[] o2 = (EntityB[]) e2.next();
                    if (!(o1 == null ? o2 == null : Arrays.equals(o1, o2)))
                        return false;
                }
                return !(e1.hasNext() || e2.hasNext());
//                if (!value.equals(that.map.get(key)))
//                    return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("EntityC{" +
                "entity=" + entity +
                ", list=" + list +
                ", map=[");
        for (Map.Entry<Set<EntityA>, List<EntityB[]>> pair : map.entrySet()) {
            result.append(pair.getKey()).append("=");
            Iterator<EntityB[]> it = pair.getValue().iterator();
            if (!it.hasNext()) {
                result.append("[]");
                break;
            }

            result.append('[');
            for (; ; ) {
                EntityB[] elem = it.next();
                result.append(Arrays.toString(elem));
                if (!it.hasNext())
                    result.append(']');
                result.append(',').append(' ');
//            Iterator<EntityB[]> iterator = pair.getValue().iterator();
//            if (! iterator.hasNext())
//                return "[]";
//            while (true) {
//                EntityB[] elem;
//                if (iterator.hasNext()) {
//                    elem = iterator.next();
//                    result.append(Arrays.toString(elem)).append(", ");
//                } else {
//                    result.append(Arrays.toString(elem)).append("]");
//                    break;
//                }
//            }
            }
        }
        return result + "]}";
    }
}
