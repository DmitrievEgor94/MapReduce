import java.util.List;

public interface CustomList<T> extends List<T> {
    default <E>CustomList<E> map(Mapper<T,E> ch) {
        CustomList<E> newList = new CustomArrayList<>();
        for (T ob : this) {
            E newObject=ch.change(ob);
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
