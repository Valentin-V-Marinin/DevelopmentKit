package seminar3.homeWorkTask3;

public class CompareArrays{
    public <T> boolean compareArrays(T[] array1, T[] array2){
        boolean result = true;
        if (array1.length != array2.length) {
            result = false;
            return result;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
