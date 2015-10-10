import java.util.ArrayList;

/**
 *
 * Command Line App
 *
 * How to Play with Argument in Java
 *
 * And How to Parse
 *
 *
 * How this Works ??
 *
 * First of all We get argument from main method then we split it and get command
 * what are doing using some other class we check is it available functions if available
 * then we move to the work they want to do if not match then we print the usage
 *
 * Credits:
 * Allah
 *
 * @author Sahid Almas
 */

public class ComApp {

    private static final ArrayList<Command> mCommands  = new ArrayList<>();
    private static String mArgsCommand = "";
    private static String mStuffArgs = "";
    private static String USAGE = "  Command Line Demo \n" +
            " Usage :" +
            " ComApp -p [text] \n" +
            " ComApp -about \n";

    public static void main(String[] args) {



        if (args.length > 0) {

            mArgsCommand = args[0];

        }

        if (args.length > 1) {
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = 1 ; i < args.length ; i++) {

                if (i == 1 ) {
                    stringBuffer.append(args[i]);
                }else if (i >= 1 && i <=  args.length ) {
                    stringBuffer.append(" ").append(args[i]);
                } else if (i == args.length) {
                    stringBuffer.append(args[i]);
                }
            }
            mStuffArgs = stringBuffer.toString();
        }


        mCommands.add(new Print("-p",mStuffArgs));
        mCommands.add(new About("-about",mStuffArgs));
        int CURSOR = 0;
        for (Command command : mCommands) {

            if (command.getFunctionName().equals( mArgsCommand )) {
                command.function(mStuffArgs);
            }
            else {
                CURSOR++;
            }

        }
        if (!mArgsCommand.equals(null)) {
            while (CURSOR == mCommands.size()) {
                System.out.println(USAGE);
                CURSOR--;
            }
        }





    }

    public static class Print extends Command {

        protected Print(String func_name, String args) {
            super(func_name, args);
        }

        @Override
        public void function(String argument) {
            System.out.println(argument);
        }

    }
    
    public static class About extends Command {

        protected About(String func_name, String args) {

            super(func_name, args);
        }

        @Override
        public void function(String argument) {

            System.out.println("Command Line Demo By Sahid <AndroidFire> Almas");
        }

    }

}
