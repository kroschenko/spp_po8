public class Main {
    public static void main(String[] args) {
    //args[0] = capitalize(args[0]);
        for (String arg : args) {
            arg = capitalize(arg);
            System.out.print(arg + " ");
        }
    }

    public static String capitalize(String str){

        if (str==null){
            return null;
        }
        else if (str.isEmpty()) {
            return "";
        }
        else{
            char firstChar = Character.toUpperCase(str.charAt(0));
            String restOfWord = str.substring(1);
            String result = firstChar + restOfWord;
            return result;
        }
    }
}

