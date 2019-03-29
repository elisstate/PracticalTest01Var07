package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Context;

public class ProcessingThread extends Thread {
    private Context context = null;
    private boolean isRunning = true;

    public ProcessingThread(Context context, int firstNumber, int secondNumber,int thirdNumber
    , int fourthNumber) {
        this.context = context;

    }
}
