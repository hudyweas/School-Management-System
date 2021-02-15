package pl.hudyweas.schoolmanagementsystem.general;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class UserInterfaceSystem {
    String[] methodPoint;

    int userInput;

    public UserInterfaceSystem(String[] methodPoint){
        this.methodPoint = methodPoint;
    }

    public void terminalChoiceInterface() {
        int numberOfChoices = this.methodPoint.length;
        for(int i = 0; i < numberOfChoices; i++){
            System.out.println(i+" - "+this.methodPoint[i]);
        }
    }

    public int getIntInput(){
        int numberOfChoices = this.methodPoint.length;

        int input;

        do{
            input = inputInt();
        }while(!checkIntInputMinToMax(input,0, numberOfChoices));

        this.userInput = input;

        return userInput;
    }

    private int inputInt(){
        Scanner in = new Scanner(System.in);

        if(in.hasNextInt())
            return in.nextInt();

        return inputInt();
    }

    private boolean checkIntInputMinToMax(int input,int min, int max){
        boolean isInputCorrect = true;
        if(input > max)
            isInputCorrect = false;
        if(input < min)
            isInputCorrect = false;
        return isInputCorrect;
    }

    private void callByName(Object obj, String funcName) {
        try {
            obj.getClass().getDeclaredMethod(funcName).invoke(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public int getUserInput() {
        return userInput;
    }
}
