/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.android_client_avatar_controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * In this class you will find TCP connetion using singleton and observer patterns
 */
public class TCPConnection extends Thread{

    // -------------------------------------
    // Attributtes
    // -------------------------------------
    private static TCPConnection uniqueInstance;
    private BufferedWriter writer;
    private boolean kill;
    private OnMessageListener observer;

    // -------------------------------------
    // Constructor
    // -------------------------------------
    private TCPConnection(){

    }

    // -------------------------------------
    // Singleton
    // -------------------------------------
    public static TCPConnection getInstance(){

        if(uniqueInstance==null) {

            uniqueInstance = new TCPConnection();
            uniqueInstance.setKill(false);
            uniqueInstance.start();

        }

        return uniqueInstance;

    }

    // -------------------------------------
    // Methods
    // -------------------------------------
    @Override
    public void run(){

        try {

            Socket socket = new Socket("192.168.20.36", 5000);

            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(!kill){

                String msg = reader.readLine();
                observer.onMessage(msg);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String msg){

        new Thread(
                ()->{

                    try {

                       writer.flush();
                       writer.write(msg+"\n");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();

    }

    // -------------------------------------
    // Getters and setters
    // -------------------------------------
    public boolean isKill() {
        return kill;
    }

    public void setKill(boolean kill) {
        this.kill = kill;
    }

    public OnMessageListener getObserver() {
        return observer;
    }

    public void setObserver(OnMessageListener observer) {
        this.observer = observer;
    }

}