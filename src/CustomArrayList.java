import java.util.ArrayList;

public class CustomArrayList<T> extends ArrayList<T> implements CustomList<T> {

    public static void main(String[] args) {

        CustomList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(56);
        customArrayList.add(56);
        customArrayList.add(34);

        customArrayList = customArrayList.map(new Mapper<Integer>() {
            @Override
            public Integer change(Integer o) {
                return o + 23;
            }
        });

        System.out.println(customArrayList);

        Integer newInt = customArrayList.reduce(new Reducer<Integer>() {
            @Override
            public Integer reduce(Integer ob1, Integer ob2) {
                return ob1 + ob2;
            }
        });

        System.out.println(newInt);
    }
}

