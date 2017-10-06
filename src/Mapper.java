public interface Mapper<T,E> {
    E change(T o);
}
