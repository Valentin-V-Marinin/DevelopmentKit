package seminar3.homeWorkTask3;

public class Main {
    public static void main(String[] args) {
        CompareArrays compareArrs = new CompareArrays();

        Integer[] array1 = {1,2,3,6,8,7,9,22};
        Integer[] array2 = {1,2,3,6,8,7,9,22};
        Integer[] array3 = {1,2,3,6,4,7,9,22};
        Integer[] array4 = {1,2,3,6,4,7,9};

        System.out.println(compareArrs.compareArrays(array1, array2));
        System.out.println(compareArrs.compareArrays(array1, array3));
        System.out.println(compareArrs.compareArrays(array3, array4));
        System.out.println("-------------------------------------------------------------------");


        String[] strArr1 = {"uno", "dos", "tres","cinco","siete","nueve"};
        String[] strArr2 = {"uno", "dos", "tres","cinco","siete","nueve"};
        String[] strArr3 = {"uno", "dos", "tres","seis","siete","nueve"};
        String[] strArr4 = {"uno", "dos", "tres","cinco","siete"};

        System.out.println(compareArrs.compareArrays(strArr1, strArr2));
        System.out.println(compareArrs.compareArrays(strArr1, strArr3));
        System.out.println(compareArrs.compareArrays(strArr1, strArr4));

    }
}
