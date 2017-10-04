import java.util.List;

public interface CustomList<T> extends List<T> {
    default CustomList<T> map(Mapper<T> ch) {
        CustomArrayList<T> newList = new CustomArrayList<>();

        for (T ob : this) {
            ob = ch.change(ob);
            newList.add(ob);
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
