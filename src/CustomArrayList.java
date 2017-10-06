import java.util.ArrayList;

public class CustomArrayList<T> extends ArrayList<T> implements CustomList<T> {

    public static void main(String[] args) {

        CustomList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(56);
        customArrayList.add(56);
        customArrayList.add(34);

        CustomList<String> newStringArrayList = customArrayList.map(new Mapper<Integer,String>() {
            @Override
            public String change(Integer o) {
                o+=23;
                return o.toString();
            }
        });

        System.out.println(newStringArrayList);

        Integer newInt = customArrayList.reduce(new Reducer<Integer>() {
            @Override
            public Integer reduce(Integer ob1, Integer ob2) {
                return ob1 + ob2;
            }
        });

        System.out.println(newInt);
    }
}

