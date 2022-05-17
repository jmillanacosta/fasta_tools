package src;
public class Main {
    static void myMethod(int num, String fname) {
        System.out.println("The name of subject number " + num + " is " + fname);
    }
    public static void main(String[] args) throws Exception {
        int number = 0;
        if (args.length == 0) {
            throw new Exception("Missing arguments");
            }else{

                for (int i = 0; i < args.length; i++) {
                    number++;
                    myMethod(i, args[i]);
                }
                System.out.println("\nThere's a total of " + number + " subjects.\n\n");
        }

    }
}