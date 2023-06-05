package ua.ivanov.ClimateControlService.utilities;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class NetworkScan {
    String networkBroadcastAdress;
    String sendMessage;
    byte[] buffer;
    int bufferSize;
    DatagramPacket sendPacket;
    DatagramPacket receivePacket;

    /**
     * @param networkBroadcastAdress the address to which the broadcast request will be sent
     * @param bufferSize the size of the buffer to which the response to the broadcast request will be written
     * @param broadcastMessage the broadcast message that will be sent
     */
    public NetworkScan(String networkBroadcastAdress, int bufferSize,String broadcastMessage) {
        this.networkBroadcastAdress = networkBroadcastAdress;
        this.bufferSize = bufferSize;
        sendMessage = broadcastMessage;

    }
    /**
     * @return ip address of Raspberry Pi Pico W
     * @throws IOException when an error occurs
     */
    public String message() throws IOException{
        String ip = "";
        
        DatagramSocket socket;
        socket = new DatagramSocket(8080);
        socket.setBroadcast(true);
        
        //створення пакеу для широкомовного запиту в мережі
        sendPacket = new DatagramPacket(sendMessage.getBytes(), sendMessage.getBytes().length,
            InetAddress.getByName(networkBroadcastAdress),8080);
        //відправлення запиту
        socket.send(sendPacket);

        //ініціалізація буферу
        buffer = new byte[bufferSize];
        for (int index = 0; index < bufferSize; index++) {
            buffer[index] = 0;
        }
        DatagramPacket receivePacket = new DatagramPacket(buffer, bufferSize);

        // пропускаємо надісланий нами широкомовний запит
        socket.receive(receivePacket);
        // отримуємо відповідь на широкомовний запит
        socket.receive(receivePacket);

        // записування отриманих даних в буфер
        for (int index = 0; index < receivePacket.getLength() && index < bufferSize; index++) {
            buffer[index] = receivePacket.getData()[index];
        }
        
        // перетворення отриманих даних в стрічку
        String recived_data = "";
        for (int index = 0; index < receivePacket.getLength(); index++) {
            recived_data = recived_data + ((char)(buffer[index]));
        }
        // Приведення адреси до потрібного формату
        ip = receivePacket.getSocketAddress().toString().split(":")[0].substring(1);
        // виведення отриманих даних та одреси того хто надіслав відповідь
        System.out.println("recived data: "+recived_data);
        System.out.println("recived data: "+ip);
        socket.close();

        return ip;
    }
    
}
