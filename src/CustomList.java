import java.util.List;

public interface CustomList<T> extends List<T> {
    default CustomList<Object> map(Mapper<T> ch) {
        CustomList<Object> newList = new CustomArrayList<>();

        for (T ob : this) {
            Object newObject=ch.change(ob);
            newList.add(newObject);
        }

        return newList;
    }

    default T reduce(Reducer<T> reducer) {
        if (this.size() == 0) return null;

        T newItem = this.get(0);

        for (int i = 1; i < this.size(); i++) {
            newItem = reducer.reduce(newItem, this.get(i));
        }

        return newItem;
    }
}
