

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] где a и b - строки а x - число  от 1 до 10 включительно  + Enter "
        );
        Scanner user = new Scanner(System.in);
        String info = user.nextLine();
        char operChar=getOperChar(info);
        String result=ExeptionsCheck(operChar,info);
        System.out.println(result);

    }
    //НАЧАЛО БЛОКА ОБРАБОТКИ ИСКЛЮЧЕНИЙ
    public static String ExeptionsCheck(char operChar, String info) throws Exception {
        String result="";

        String[] blockstr= info.split("(\\s+[+-/*/]\\s*)");


//    System.out.println(operChar);
//    for(String x:blockstr){
//        System.out.println(x);
//    }

        if(operChar==' '){throw new Exception("Нужно ввести арифметическую операцию + - * /");}
        if(!blockstr[0].matches("\".*\"")){
            throw new Exception("Первым аргументом должна идти строка выделенная \" \"");
        }

        if(blockstr[0].length()>12||blockstr[1].length()>12){
            throw new Exception("Строка должна быть не более 10 символов");
        }
        if (blockstr[1].matches("\\d*") ){
            if (!blockstr[1].matches("[1-9]|10")){
                throw new Exception("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");}
        }
        if (!blockstr[1].matches("\\d*")&& (operChar=='*'||operChar=='/') ){

            throw new Exception("Деление и умножение должно быть только на число");}
        if (operChar=='/'&&blockstr[1].matches("\\d*")&&((blockstr[0].length()-2)<Integer.valueOf(blockstr[1]))){
            throw new Exception("Кол-во символов в строке не должно быть больше числа делителя");
        }

        if(blockstr[0].matches("\".*\"") && blockstr[1].matches("\".*\"")&& (operChar=='+'||operChar=='-')){

        }
        if(blockstr[0].matches("\".*\"") && blockstr[1].matches("\\d*")&& (operChar=='*'||operChar=='/')){
            int str2int= Integer.valueOf(blockstr[1]);
            result= str_int(blockstr[0],str2int,operChar);

        }
        if(blockstr[0].matches("\".*\"") && blockstr[1].matches("\".*\"")&& (operChar=='+'||operChar=='-')){

            result= str_str(blockstr[0],blockstr[1],operChar);

        }

        return  result;
    }
//КОНЕЦ БЛОКА ОБРАБОТКИ ИСКЛЮЧЕНИЙ

    // НАЧАЛО БЛОКА ОБРАБОТКИ ОПЕРАЦИЙ  СТРОКА И СТРОКА
    public static String str_str(String str1,String str2,char operChar){
        String result="";
        if(operChar=='+'){
            result= str1.substring(0,str1.length()-1)+str2.substring(1,str2.length());
        }
        if(operChar=='-'){
            if(str1.contains(str2.substring(1,str2.length()-1))){
                String resM=str1.replace(str2.substring(1,str2.length()-1),"");
                result=resM;

            }
            else {result=str1;}
        }
        return result;
    }
//КОНЕЦ БЛОКА ОБРАБОТКИ ОПЕРАЦИЙ  СТРОКА И СТРОКА

    //НАЧАЛО БЛОКА ОБРАБОТКИ ОПЕРАЦИЙ  СТРОКА И ЧИСЛО
    public static String str_int(String str1,int integ,char operChar){
        String result1="";
        if(operChar=='*') {
            String res2 = "";
            for (int i = 0; i < integ; i++) {
                if (i < integ) {
                    res2 =res2 + str1.substring(1, (str1.length()-1));

                }
            }
            result1 = "\"" + res2 + "\"";
            if(res2.length()>40){
                result1="\"" + res2.substring(0,40) +"..." + "\"";
            }
        }
        if(operChar=='/'){
            int howMany=(str1.length()-2)/integ;
            result1= str1.substring(0,howMany+1)+"\"" ;
        }
        return result1;
    }
//КОНЕЦ БЛОКА ОБРАБОТКИ ОПЕРАЦИЙ  СТРОКА И ЧИСЛО


    //НАЧАЛО БЛОКА ОБРАБОТКИ ОПЕРАЦИЙ  ПО ПОЛУЧЕНИЮ ОПЕРАЦИИ
    public static Character getOperChar(String UserText){//Метод поиска знака операции
        char res=' ';
        for (int i=0;i<UserText.length();i++){
            if(UserText.charAt(i)=='*'){
                res=UserText.charAt(i);
            }
            else if (UserText.charAt(i)=='/') {
                res=UserText.charAt(i);
            }
            else if(UserText.charAt(i)=='+'){
                res=UserText.charAt(i);
            }
            else if(UserText.charAt(i)=='-'){
                res=UserText.charAt(i);
            }
        }
        return res;
    }
//КОНЕЦ БЛОКА ОБРАБОТКИ ОПЕРАЦИЙ  ПО ПОЛУЧЕНИЮ ОПЕРАЦИИ

}