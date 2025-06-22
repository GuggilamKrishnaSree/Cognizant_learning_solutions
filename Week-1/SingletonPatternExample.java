//Different ways of implementing Singleton classes.

// class Logger{ //Thread-unsafe Singleton class
//     private static Logger logger;
//     private Logger(){}
//     public static Logger getInstance(){
//         if(logger == null)
//         logger = new Logger();
//         return logger;
//     }
// }

// 

// class Logger{ //Thread-safe and better performance Singleton class
//     private static Logger logger;
//     private Logger(){}
//     public static Logger getInstance(){
//         if(logger == null)
//         {
//             synchronized(Logger.class){
//                 if(logger == null)
//                 logger = new Logger();
//             }
//         }
//         return logger;
//     }
// }



class Logger{ //Static initialzation, also referred as early initialization Singleton class, it is thread safe.
    private static Logger logger = new Logger();
    private Logger(){}
    public static Logger getInstance(){
        return logger;
    }
}

public class SingletonPatternExample {
    public static void main(String[] args)
    {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println(logger1 == logger2);
    }
}
