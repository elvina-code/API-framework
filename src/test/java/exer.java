public class exer {

    public static void main(String[] args) {
        String str="mystring123";
        char [] arr = str.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            try{
                count +=Integer.parseInt(arr[i] + "");
            }catch (Exception e){
                continue;
            }
        }
        System.out.println(count);
        }

}


