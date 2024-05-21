package com.example.serialtest;

import javafx.collections.FXCollections;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.util.Arrays;
import java.util.List;

public class MessageListener implements SerialPortManager {

    private final List<String> portList;
    private String port;



    public MessageListener() {
        portList = FXCollections.observableArrayList();
        portList.addAll(Arrays.asList(SerialPortList.getPortNames()));
    }

    @Override
    public List<String> getListOfPorts() {
        return this.portList;
    }

    @Override
    public void setPort(String port) {
        this.port = port;
    }

    public void listen(){
        try{
            SerialPort serialPort = new SerialPort(this.port);
            if(serialPort.openPort()){
                serialPort.setParams(
                        SerialPort.BAUDRATE_9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
//                serialPort.writeBytes(stringOut.getBytes());
//                serialPort.readBytes()

                serialPort.closePort();
            }
        }catch (SerialPortException serialPortException){

        }
    }
}
