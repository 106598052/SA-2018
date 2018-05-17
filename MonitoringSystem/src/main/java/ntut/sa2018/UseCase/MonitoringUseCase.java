package ntut.sa2018.UseCase;

import ntut.sa2018.Domain.Host.Host;
import ntut.sa2018.Others.MontioringHost.Montioring;
import org.omg.PortableInterceptor.HOLDING;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MonitoringUseCase {
    private ArrayList<Host> hostArrayList;
    private Timer timer;

    public MonitoringUseCase(ArrayList<Host> hostArrayList){
        this.hostArrayList = hostArrayList;
        this.timer = new Timer();
    }
    public void run(){
        for(Host host : hostArrayList) {
            timer = new Timer();
            TimerTask Monitor = new Montioring(host);
            timer.schedule(Monitor, 1000, host.getCheckInterval()*1000);
        }
    }

    public void updateHost(ArrayList<Host> hostArrayList){
        this.hostArrayList = hostArrayList;
    }
}